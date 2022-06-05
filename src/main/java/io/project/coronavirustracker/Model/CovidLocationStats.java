package io.project.coronavirustracker.Model;

/**
 * @author Wayne Sidney
 * Created on {04/06/2022}
 */
public class CovidLocationStats {

    private String location;

    private int numberOfCases;

    private int numberOfDeaths;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public int getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public void setNumberOfDeaths(int numberOfDeaths) {
        this.numberOfDeaths = numberOfDeaths;
    }

    @Override
    public String toString() {
        return "CovidLocationStats{" +
                "location='" + location + '\'' +
                ", numberOfCases=" + numberOfCases +
                ", numberOfDeaths=" + numberOfDeaths +
                '}';
    }
}
