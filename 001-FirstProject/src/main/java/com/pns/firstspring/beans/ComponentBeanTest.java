package com.pns.firstspring.beans;

import org.springframework.stereotype.Component;

@Component("demoComponent")
public class ComponentBeanTest {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		// TODO Auto-generated method stub
		return id+":"+name;
	}
}
