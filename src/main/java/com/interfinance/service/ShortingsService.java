package com.interfinance.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.interfinance.domain.Shortings;
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
	
}
