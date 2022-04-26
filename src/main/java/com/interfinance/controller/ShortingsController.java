package com.interfinance.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import  java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.interfinance.domain.Shortings;
import com.interfinance.model.ShortingsResponse;
import com.interfinance.service.ShortingsService;

@RestController
@RequestMapping("/shortings")
public class ShortingsController {
	
	private ShortingsService shortingservice;
	private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
	public ShortingsController(ShortingsService shortingservice) {
		this.shortingservice = shortingservice;
	}
	
//	@GetMapping("/listFromApi")
//	public String list ()
//	{
//		System.out.println("into");
//		String uri = "https://ssr.finanstilsynet.no/api/v2/instruments";
//		String result  = restTemplate.getForObject(uri, String.class);
//		return result;
//	}
//	
	@RequestMapping(value="/fullShortings")
	public String listForShortings ()
	{
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      return restTemplate.exchange("https://ssr.finanstilsynet.no/api/v2/instruments", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(path="listByISIN/{isin}" )
	public ShortingsResponse isinValue(@PathVariable("isin") String isin)
	{
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      ResponseEntity<String> object = restTemplate.exchange("https://ssr.finanstilsynet.no/api/v2/instruments", HttpMethod.GET, entity, String.class);
	      Map<Object, ShortingsResponse> map=shortingservice.convertJson2Map(object);
	      ShortingsResponse shortingResponse = map.get(isin);
	      return shortingResponse;
	}
	
	@RequestMapping(value = "/{dateString}", method = RequestMethod.GET)
	  public ShortingsResponse getSomething(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dateString) {

	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      ResponseEntity<String> object = restTemplate.exchange("https://ssr.finanstilsynet.no/api/v2/instruments", HttpMethod.GET, entity, String.class);
	      Map<Object, ShortingsResponse> map=shortingservice.convertJson2Map(object);
	      ShortingsResponse shortingResponse = map.get(dateString);
	   return shortingResponse;
	  }

	
//	 @GetMapping("/allShortings")
//	    public List<Shortings> listAllShortings() {
//	        return shortingservice.list();
//	    }
//	

}
