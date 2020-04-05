package com.suraj.demo.respository;

import java.util.List;

import com.suraj.demo.dto.BeveragesDto;

public interface IBeverageRepository {

	List<BeveragesDto> findAll();
	
	List<BeveragesDto> findByName(String name);
}
