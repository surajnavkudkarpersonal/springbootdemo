package com.suraj.demo.model;

import lombok.Data;

@Data
public class Beverage {

	private long id;
	private String name;
	private String desc;
	private String category;

	public Beverage(long id ,String name, String desc, String category) {
		this.id=id;
		this.name = name;
		this.desc = desc;
		this.category = category;
	}
}