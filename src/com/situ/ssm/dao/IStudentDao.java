package com.situ.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.entity.Student;
import com.situ.ssm.vo.StudentSearchCondition;

public interface IStudentDao {

	List<Student> listDemo();

	List<Student> list();

	int getTotalCount(StudentSearchCondition condition);

	List<Student> findPageBeanListByCondition(@Param("condition")StudentSearchCondition condition, @Param("offset")Integer offset);

	int deleteById(Integer id);

}
