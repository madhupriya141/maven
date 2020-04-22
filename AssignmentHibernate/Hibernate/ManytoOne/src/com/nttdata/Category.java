package com.nttdata;

import java.util.Set;

public class Category {
	private int categoryid;
	private String name;
	private Set<Product> pro;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getPro() {
		return pro;
	}
	public void setPro(Set<Product> pro) {
		this.pro = pro;
	}
}
