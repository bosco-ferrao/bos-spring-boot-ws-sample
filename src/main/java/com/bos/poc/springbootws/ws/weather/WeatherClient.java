package com.bos.poc.springbootws.ws.weather;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.bos.poc.springbootws.ws.weather.model.GetWeather;
import com.bos.poc.springbootws.ws.weather.model.GetWeatherResponse;
import com.bos.poc.springbootws.ws.weather.model.ObjectFactory;


public class WeatherClient extends WebServiceGatewaySupport {
	public static final String WEBSERVICE_URL = "http://www.webservicex.com/globalweather.asmx";
	

	public GetWeatherResponse getWeather(String cityName, String countryName) {
		ObjectFactory objectFactory = new ObjectFactory();
		GetWeather gw = objectFactory.createGetWeather();
		gw.setCityName(cityName);
		gw.setCountryName(countryName);
		GetWeatherResponse getWeatherResponse = (GetWeatherResponse) getWebServiceTemplate().marshalSendAndReceive(WEBSERVICE_URL, gw, new SoapActionCallback("http://www.webserviceX.NET/GetWeather"));
		return getWeatherResponse;
	}
}
