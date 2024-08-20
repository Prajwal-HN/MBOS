package com.curd.master.controller;

import com.curd.master.model.WeatherInfoResponse;
import com.curd.master.service.WeatherInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherInfoController {
    private final WeatherInfoService weatherInfoService;

    public WeatherInfoController(WeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @GetMapping
    public WeatherInfoResponse getWeatherInfoByCity(@RequestParam("cityName") String cityName) throws JsonProcessingException {
        return weatherInfoService.getWeatherInfoByCity(cityName);
    }
}
