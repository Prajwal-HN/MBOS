package com.curd.master.service.impl;

import com.curd.master.model.WeatherInfoResponse;
import com.curd.master.service.WeatherInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class WeatherInfoServiceImpl implements WeatherInfoService {
    private final String weatherInfoOpenUrl;
    private final String weatherInfoApiKey;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WeatherInfoServiceImpl(@Value("${weather.info.url}") String weatherInfoOpenUrl,
                                  @Value("${weather.info.api.key}") String weatherInfoApiKey,
                                  RestTemplate restTemplate,
                                  ObjectMapper objectMapper) {
        this.weatherInfoOpenUrl = weatherInfoOpenUrl;
        this.weatherInfoApiKey = weatherInfoApiKey;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public WeatherInfoResponse getWeatherInfoByCity(String cityName) throws JsonProcessingException {
        String url = UriComponentsBuilder.fromHttpUrl(weatherInfoOpenUrl)
                .queryParam("q", cityName)
                .queryParam("appid", weatherInfoApiKey)
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        log.info("weather info response : {}", response);
        return objectMapper.readValue(response, WeatherInfoResponse.class);

    }
}
