package com.dvb.spring.weather;

import java.lang.String;

interface IRemoteService
{
	String getDefaultCity();
	String getDefaultUnit();
	void startGetWeatherInfoTask();
}