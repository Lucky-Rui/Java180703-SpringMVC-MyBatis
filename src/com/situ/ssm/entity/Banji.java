package com.situ.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class Banji {
	private Integer id;
	private String name;
	// 一个班可以学习多门课程，一对多
	private List<Course> courseList = new ArrayList<>();
	// 一个班有多个学生，一对多
	private List<Student> studentList = new ArrayList<>();

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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", courseList=" + courseList + ", studentList=" + studentList
				+ "]";
	}

}
