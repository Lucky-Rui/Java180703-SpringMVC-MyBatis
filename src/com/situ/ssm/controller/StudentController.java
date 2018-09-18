package com.situ.ssm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.service.impl.StudentServiceImpl;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	private IStudentService studentService = new StudentServiceImpl();

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Student> list() {
		List<Student> list = studentService.list();
		return list;
	}
	
	
}
