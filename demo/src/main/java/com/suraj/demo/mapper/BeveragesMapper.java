package com.suraj.demo.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.suraj.demo.dto.BeveragesDto;
import com.suraj.demo.model.Beverage;

public class BeveragesMapper {

	public static Beverage toBeverages(BeveragesDto beveragesDto) {
		return new Beverage(beveragesDto.getId(), beveragesDto.getName(), beveragesDto.getDescription(),
				beveragesDto.getCategory());
	}
	
	public static List<Beverage>  toBeveragesList(List<BeveragesDto> listOfBeveragesDto) {
		List<Beverage> listOfBeverages = new ArrayList<Beverage>();
		Iterator<BeveragesDto> iteratorBeveragesDto = listOfBeveragesDto.iterator();
		while (iteratorBeveragesDto.hasNext()) {
			listOfBeverages.add(toBeverages(iteratorBeveragesDto.next()));
		}
		return listOfBeverages;

	}
}
