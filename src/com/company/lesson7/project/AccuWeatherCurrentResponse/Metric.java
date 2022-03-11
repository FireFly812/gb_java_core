package com.company.lesson7.project.AccuWeatherCurrentResponse;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Metric{
    @JsonProperty("Value") 
    public double value;
    @JsonProperty("Unit") 
    public String unit;
    @JsonProperty("UnitType") 
    public int unitType;
}
