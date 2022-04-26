package com.interfinance.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.interfinance.model.Events;
import com.interfinance.model.ShortingsResponse;
import com.interfinance.repository.ShortingsRepository;

@Service
public class ShortingsService {
	
	private ShortingsRepository shortingsRepository;

	public ShortingsService(ShortingsRepository shortingsRepository) {
		this.shortingsRepository = shortingsRepository;
	}
	
//	 public List<Shortings> list() {
//		 Iterable<Shortings> shortingsFindAll = shortingsRepository.findAll();
//		List<Shortings> shortingList = StreamSupport.stream(shortingsFindAll.spliterator(), false).map(shortings->{
//	    Shortings shortingsObj = new Shortings();
//			 BeanUtils.copyProperties(shortings, shortingsObj);
//			 return shortingsObj;
//		 }).collect(Collectors.toList());
//		return shortingList;
//	    }
	

	public Map<Object, ShortingsResponse> convertJson2Map(ResponseEntity<String> object) {

		String body = object.getBody();
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<ShortingsResponse>>() {
		}.getType();
		List<ShortingsResponse> collectionsResponse = new ArrayList<ShortingsResponse>();
		collectionsResponse = gson.fromJson(body, collectionType);
		Map<Object, ShortingsResponse> map = convertArrayListToHashMap(collectionsResponse);
		return map;
	   }

	public Map<Object, ShortingsResponse> convertArrayListToHashMap(List<ShortingsResponse> collectionsResponse)

	   {
		Map<Object, ShortingsResponse> hashMap = new HashMap<Object, ShortingsResponse>();
		for (ShortingsResponse str : collectionsResponse) {
			hashMap.put(str.getIsin(), str);
		}
		return hashMap;
   }
	
	
	public ShortingsResponse convertShortingsToEvents(ShortingsResponse shortingsResponse,String date)
	{   
		ShortingsResponse shortingsResponseObj = new ShortingsResponse();
		Events events = new Events();
		List<Events> eventsList = new ArrayList<Events>();
		Map<Object, Events> mapForEvents = convertArrayListToHashMap2(shortingsResponse,date);
		events =  mapForEvents.get(date);
		eventsList.add(events);
		shortingsResponseObj.setIsin(shortingsResponse.getIsin());
		shortingsResponseObj.setIssuerName(shortingsResponse.getIssuerName());
		shortingsResponseObj.setEvents(eventsList);
		return shortingsResponseObj;
	}

	
	public Map<Object, Events> convertArrayListToHashMap2(ShortingsResponse collectionsResponse,String date)
	{
		Map<Object, Events> hashMap = new HashMap<Object, Events>();
		List<ShortingsResponse> shortinglist = new ArrayList<ShortingsResponse>();
		shortinglist.add(collectionsResponse);
		String datekey = new String();
		Events eventsObj = new Events();
		for (ShortingsResponse str : shortinglist) {
			for(int i=0;i<str.getEvents().size();i++)
			{    
				  datekey = str.getEvents().get(i).getDate();
				  if(datekey.equalsIgnoreCase(date))
				  {
				  eventsObj.setActivePositions(str.getEvents().get(i).getActivePositions());
				  eventsObj.setDate(str.getEvents().get(i).getDate());
				  eventsObj.setShortPercent(str.getEvents().get(i).getShortPercent());
				  eventsObj.setShares(str.getEvents().get(i).getShares());
				  hashMap.put(datekey, eventsObj);
				  }
			}
		
		}
		
		return hashMap;
	
        }
	}
