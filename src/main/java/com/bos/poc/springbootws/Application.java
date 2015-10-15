package com.bos.poc.springbootws;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bos.poc.springbootws.ws.weather.WeatherClient;


@Configuration
@ComponentScan(basePackages={"com.bos"})
@EnableAutoConfiguration
public class Application {
    public static void main(final String[] arguments) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, arguments);
//        WeatherClient wc = (WeatherClient) context.getBean("weatherClient");
//        
    }
}

