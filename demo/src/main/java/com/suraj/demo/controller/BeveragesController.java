package com.suraj.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.util.StringUtils;
import com.suraj.demo.dto.BeveragesDto;
import com.suraj.demo.mapper.BeveragesMapper;
import com.suraj.demo.model.Beverage;
import com.suraj.demo.respository.IBeverageRepository;

@RestController
public class BeveragesController {

	@Autowired
	@Qualifier("beveragesRepository")
	private IBeverageRepository beverageRepository;

	@GetMapping("/beverages")
	public List<Beverage> greeting(@RequestParam(value = "name", required = false) String name) {
		List<BeveragesDto> beveragesList = new ArrayList<BeveragesDto>();
		if (StringUtils.isNullOrEmpty(name)) {
			beveragesList = beverageRepository.findAll();
		} else {
			beveragesList = beverageRepository.findByName(name);
		}

		return BeveragesMapper.toBeveragesList(beveragesList);
	}
}