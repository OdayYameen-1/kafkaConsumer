package com.DemoCounsumerOfkafka.kafkaConsumer.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class User implements Serializable{
	@Id
	private Integer id;
	private String name;
	public User(int id, String name) {
	
		this.id = id;
		this.name = name;
	}
	public User() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}