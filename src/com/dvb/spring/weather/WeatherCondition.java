package com.dvb.spring.weather;

import com.gotechcn.yanglaolauncher.R;



public interface WeatherCondition {
	public static String[] Condition={
	"tornado","tropical storm","hurricane","severe thunderstorms","thunderstorms",
	"mixed rain and snow","mixed rain and sleet","mixed snow and sleet","freezing drizzle","drizzle",
 	"freezing rain","showers","showers","snow flurries","light snow showers",
 	"blowing snow","snow","hail","sleet","dust",
 	"foggy","haze","smoky","blustery","windy",
 	"cold","cloudy","mostly cloudy","mostly cloudy","partly cloudy",
 	"partly cloudy","clear", "sunny","fair","fair",
 	"mixed rain and hail","hot","isolated thunderstorms","scattered thunderstorms","scattered thunderstorms",
 	"scattered showers","heavy snow","scattered snow showers","heavy snow","partly cloudy",
 	"thundershowers","snow showers","isolated thundershowers","not available"};
	
	public static int[] WeatherImg={
		R.drawable.weather014,R.drawable.weather014,R.drawable.weather014,R.drawable.weather00,R.drawable.weather00,
		R.drawable.weather07,R.drawable.weather07,R.drawable.weather06,R.drawable.weather07,R.drawable.weather03,
		R.drawable.weather07,R.drawable.weather09,R.drawable.weather09,R.drawable.weather06,R.drawable.weather011,
		R.drawable.weather06,R.drawable.weather06,R.drawable.weather06,R.drawable.weather06,R.drawable.weather012,
		R.drawable.weather012,R.drawable.weather012,R.drawable.weather012,R.drawable.weather013,R.drawable.weather013,
		R.drawable.weather013,R.drawable.weather05,R.drawable.weather05,R.drawable.weather010,R.drawable.weather010,
		R.drawable.weather010,R.drawable.weather010,R.drawable.weather04,R.drawable.weather04,R.drawable.weather04,
		R.drawable.weather07,R.drawable.weather04,R.drawable.weather08,R.drawable.weather08,R.drawable.weather08,
		R.drawable.weather09,R.drawable.weather06,R.drawable.weather011,R.drawable.weather06,R.drawable.weather010,
		R.drawable.weather08,R.drawable.weather011,R.drawable.weather08,
	};
}
