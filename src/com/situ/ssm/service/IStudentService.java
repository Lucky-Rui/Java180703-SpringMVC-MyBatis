package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.entity.Student;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.StudentSearchCondition;

public interface IStudentService {

	List<Student> listDemo();

	List<Student> list();

	PageBean<Student> getPageBean(StudentSearchCondition condition);

	boolean deleteById(Integer id);
	
}
