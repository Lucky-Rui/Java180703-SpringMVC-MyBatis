package com.situ.ssm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.situ.ssm.dao.IStudentDao;
import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.util.MyBatisUtil;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.StudentSearchCondition;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao studentDao = null;
	private SqlSession sqlSession = null;

	public StudentServiceImpl() {
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(IStudentDao.class);
	}

	public List<Student> listDemo() {
		return studentDao.listDemo();
	}

	@Override
	public List<Student> list() {
		return studentDao.list();
	}

	@Override
	public PageBean<Student> getPageBean(StudentSearchCondition condition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageNo(condition.getPageNo());
		pageBean.setPageSize(condition.getPageSize());
		// 总记录数（是符合condition条件的总记录数）
		int totalCount = studentDao.getTotalCount(condition);
		pageBean.setTotalCount(totalCount);
		// 一共有多少页
		int totalPage = (int) Math.ceil((double) totalCount / condition.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 得到当前页的数据
		int offset = (condition.getPageNo() - 1) * condition.getPageSize();
		List<Student> list = studentDao.findPageBeanListByCondition(condition, offset);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public boolean deleteById(Integer id) {
		int count = studentDao.deleteById(id);
		sqlSession.commit();
		return count == 1 ? true : false;
	}

	@Override
	public boolean addStudent(Student student) {
		int count = studentDao.addStudent(student);
		return count == 1 ? true : false;
	}

}
