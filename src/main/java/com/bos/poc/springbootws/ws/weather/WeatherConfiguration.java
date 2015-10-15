package com.bos.poc.springbootws.ws.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.bos.poc.springbootws.ws.weather.model");
		return marshaller;
	}

	@Bean
	public WeatherClient weatherClient(Jaxb2Marshaller marshaller) {
		WeatherClient client = new WeatherClient();
		client.setDefaultUri("http://www.webserviceX.NET");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
