package com.interfinance.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.interfinance.domain.Shortings;
import com.interfinance.service.ShortingsService;

@RestController
@RequestMapping("/shortings")
public class ShortingsController {
	
	private ShortingsService shortingservice;

	public ShortingsController(ShortingsService shortingservice) {
		this.shortingservice = shortingservice;
	}
	
	@GetMapping("/listFromApi")
	public String list ()
	{
		String uri = "https://ssr.finanstilsynet.no/api/v2/instruments";
		RestTemplate restTemplate = new RestTemplate();
		String result  = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@RequestMapping(path="listByISIN/{isin}" )
	public Shortings isinValue(@PathVariable("isin") String isin)
	{
		System.out.println("value of ISIN from REST API" +isin);
		 return shortingservice.getIsinValue(isin) ;
		
	}
	
	 @GetMapping("/allShortings")
	    public List<Shortings> listAllShortings() {
	        return shortingservice.list();
	    }
	

}
