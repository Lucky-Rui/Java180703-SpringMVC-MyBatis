package com.situ.ssm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.service.impl.StudentServiceImpl;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.StudentSearchCondition;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	private IStudentService studentService = new StudentServiceImpl();

	@RequestMapping(value = "/listDemo")
	@ResponseBody
	public List<Student> list() {
		List<Student> list = studentService.listDemo();
		return list;
	}

	@RequestMapping(value = "/list")
	public String list(Integer pageNo, Integer pageSize, Model model) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 3;
		}
		List<Student> list = studentService.list();
		model.addAttribute("list", list);
		return "/student/student_list";
	}

	@RequestMapping(value = "/pageList")
	public String pageList(Integer pageNo, Integer pageSize,String name, Integer age, String gender, Model model) {
		if (pageNo == null || pageNo.equals("")) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = 3;
		}
		StudentSearchCondition condition = new StudentSearchCondition(pageNo, pageSize, name, age, gender);
		PageBean<Student> pageBean = studentService.getPageBean(condition);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("condition",condition);
		return "/student/student_list";
	}
	
	@RequestMapping(value = "/deleteById")
	public String deleteById(Integer id, Integer pageNo) {
		studentService.deleteById(id);
		return "redirect:/student/pageList.action?pageNo=" + pageNo;
	}
}
