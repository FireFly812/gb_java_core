package com.company.lesson7.project.AccuWeatherCurrentResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CurrentResponse {
    @JsonProperty("LocalObservationDateTime")
    public Date localObservationDateTime;
    @JsonProperty("EpochTime")
    public int epochTime;
    @JsonProperty("WeatherText")
    public String weatherText;
    @JsonProperty("WeatherIcon")
    public int weatherIcon;
    @JsonProperty("HasPrecipitation")
    public boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    public Object precipitationType;
    @JsonProperty("IsDayTime")
    public boolean isDayTime;
    @JsonProperty("Temperature")
    public Temperature temperature;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;
}
