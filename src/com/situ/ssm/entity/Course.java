package com.situ.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private Integer id;
	private String name;
	private Integer credit;
	//一个课程可以被多个班级学习
	private List<Banji> banjiList = new ArrayList<>();

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

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public List<Banji> getBanjiList() {
		return banjiList;	
	}

	public void setBanjiList(List<Banji> banjiList) {
		this.banjiList = banjiList;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credit=" + credit + ", banjiList=" + banjiList + "]";
	}

}
