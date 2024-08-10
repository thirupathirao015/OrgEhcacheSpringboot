package com.example.OrgEhcacheSpringboot.controller;

import java.util.List;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrgEhcacheSpringboot.pojo.Employee;

import jakarta.annotation.PostConstruct;


@RestController
public class EmployeeController {
	
	@Autowired
	private CacheManager cachemanager;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init() {		
		loadCache();
	}
	
	public void loadCache() {
		System.out.println("Cache loading started.......");
		try {
			Cache<String,Object> cache = cachemanager.getCache("tempcache");
				String sql = "SELECT * FROM employee";		
				List<Employee> employee = jdbcTemplate.query(sql,
		                BeanPropertyRowMapper.newInstance(Employee.class));
				cache.put("AllEmpList", employee);
				System.out.println("Cache loaded successfully.......");
		}catch(Exception ee) {
			System.out.println(ee);
		}	
	}
	
	//http://localhost:9999/allemp		
	@GetMapping("/allemp")
	public List<Employee> getAllEmp() {
		Cache cache = cachemanager.getCache("tempcache");
		List<Employee> employee = (List<Employee>) cache.get("AllEmpList");
		return employee;
	}
	
	
}
