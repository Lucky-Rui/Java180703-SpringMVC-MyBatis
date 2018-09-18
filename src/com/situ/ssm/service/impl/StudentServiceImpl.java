package com.situ.ssm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.situ.ssm.dao.IStudentDao;
import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.util.MyBatisUtil;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao studentDao = null;

	public StudentServiceImpl() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(IStudentDao.class);
	}

	public List<Student> list() {
		return studentDao.list();
	}

}
