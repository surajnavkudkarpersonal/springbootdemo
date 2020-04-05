package com.suraj.demo.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.suraj.demo.dto.BeveragesDto;

@Repository
public class BeveragesRepository implements IBeverageRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final static String TABLE_BEVERAGES = "beverages";
	private final static String COLUMN_ID = "id";
	private final static String COLUMN_NAME = "name";
	private final static String COLUMN_DESCRIPTION = "description";
	private final static String COLUMN_CATEGORY = "category";

	@Override
	public List<BeveragesDto> findAll() {

		return namedParameterJdbcTemplate.query("select * from " + TABLE_BEVERAGES,
				new BeanPropertyRowMapper<BeveragesDto>(BeveragesDto.class));
	}

	@Override
	public List<BeveragesDto> findByName(String name) {

		String query = "select * from " + TABLE_BEVERAGES + " where LOWER(" + COLUMN_NAME + ") like :pname";
		String finalName = "%" + name.toLowerCase().trim() + "%";
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("pname", finalName);

		return namedParameterJdbcTemplate.query(query, mapSqlParameterSource,
				new BeanPropertyRowMapper<BeveragesDto>(BeveragesDto.class));
	}

}