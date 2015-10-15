package com.bos.poc.springbootws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bos.poc.springbootws.ws.weather.WeatherClient;
import com.bos.poc.springbootws.ws.weather.model.GetWeatherResponse;

@Controller
@RequestMapping("/partials")
public class PartialsController {
    private static Logger LOGGER = LoggerFactory.getLogger(PartialsController.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private WeatherClient weatherClient;

    @RequestMapping("/input-city-country-data")
    String inputBarcode() {
        return "partials/input-city-country-data";
    }
    
    @ResponseBody
    @RequestMapping("/lookup-data/{cityName}/{countryName}")
    public GetWeatherResponse getWeather(@PathVariable String cityName, @PathVariable String countryName) {
        return weatherClient.getWeather(cityName, countryName);
    }
    
    @ResponseBody
    @RequestMapping("/stop")
    public void stopService() {
        LOGGER.info("Stopping service");
        SpringApplication.exit(context);
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NotFoundException.class)
//    public void handleNotFoundException(Exception exception) {
//        LOGGER.error(exception.getMessage(), exception);
//    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handleException(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
    }
}
