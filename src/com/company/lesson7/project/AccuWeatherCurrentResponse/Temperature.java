package com.company.lesson7.project.AccuWeatherCurrentResponse;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Temperature{
    @JsonProperty("Metric") 
    public Metric metric;
    @JsonProperty("Imperial") 
    public Imperial imperial;
}
