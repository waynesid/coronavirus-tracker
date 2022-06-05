package io.project.coronavirustracker.Service;

import io.project.coronavirustracker.Model.CovidLocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wayne Sidney
 * Created on {04/06/2022}
 */
@Service
public class CovidTrackerService {

    public static String Virus_String_url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/01-01-2021.csv";
    List<CovidLocationStats> newstats = new ArrayList<>();

    public List<CovidLocationStats> getNewstats() {
        return newstats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {

        List<CovidLocationStats> covidStats = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Virus_String_url))
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            CovidLocationStats covidLocationStats = new CovidLocationStats();
            covidLocationStats.setLocation(record.get(2));
            covidLocationStats.setNumberOfCases(Integer.parseInt(record.get(7)));
            covidLocationStats.setNumberOfDeaths(Integer.parseInt(record.get(8)));

            covidStats.add(covidLocationStats);
            //System.out.println(covidStats);
        }
        this.newstats=covidStats;
    }
}
