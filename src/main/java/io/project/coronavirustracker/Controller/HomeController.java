package io.project.coronavirustracker.Controller;

import io.project.coronavirustracker.Model.CovidLocationStats;
import io.project.coronavirustracker.Service.CovidTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wayne Sidney
 * Created on {04/06/2022}
 */
@Controller
public class HomeController {

    @Autowired
    private CovidTrackerService covidTrackerService;

    @GetMapping("/")
    public String home(Model model) {

        List<CovidLocationStats> allStats = covidTrackerService.getNewstats();

        model.addAttribute("covidLocationStats", allStats);
        model.addAttribute("location", allStats.get(0));
        model.addAttribute("numberOfCases",allStats.get(1));
        model.addAttribute("numberOfDeaths", allStats.get(2));
        return "home";
    }
}
