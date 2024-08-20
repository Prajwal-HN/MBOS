package com.curd.master.service;

import com.curd.master.model.WeatherInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherInfoService {
    WeatherInfoResponse getWeatherInfoByCity(String cityName) throws JsonProcessingException;
}
