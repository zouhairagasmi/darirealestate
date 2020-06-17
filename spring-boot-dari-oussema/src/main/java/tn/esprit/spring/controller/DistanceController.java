package tn.esprit.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DistanceController {
	public static double callapi(String s1, String s2) {
		String url1 = "http://dev.virtualearth.net/REST/V1/Routes/Driving?o=json&wp.0=aa&wp.1=bb&avoid=minimizeTolls&key=AtC8c_FWYHENkcT1NHycFyZxAWyEK0NC_Oj4Vw1O3bWTRJM9re33XXBT4QJNlEfm";
		String url2 = url1.replace("aa", s1);
		String url = url2.replace("bb", s2);
		RestTemplate restTemplate = new RestTemplate();
		Object o = restTemplate.getForObject(url, Object.class);
		String Dis = o.toString().substring(o.toString().indexOf("}, travelDistance=") + 18,
				o.toString().indexOf("}, travelDistance=") + 24);
		try {
			double i=Double.parseDouble(Dis);
		}catch(Exception NumberFormatException){
			return 0;
		}
		return Double.parseDouble(Dis);
	}
}