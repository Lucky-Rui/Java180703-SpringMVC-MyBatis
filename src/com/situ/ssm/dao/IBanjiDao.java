package com.situ.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.entity.Banji;

public interface IBanjiDao {
	/**
	 * 总记录数
	 * 
	 * @return 所有数据的个数
	 */
	int getTotalCount();

	/**
	 * 当前页的数据
	 * 
	 * @param offset
	 * @param pageSize
	 * @return list集合
	 */
	List<Banji> pageList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

	/**
	 * 根据id删除班级
	 * 
	 * @param id
	 * @return 影响的行数
	 */
	int deleteById(Integer id);

	/**
	 * 查找班级是否有重名
	 * 
	 * @param name
	 * @return 重名的个数
	 */
	int findCountByName(String name);

	/**
	 * 添加班级
	 * 
	 * @param banji
	 * @return
	 */
	int addBanji(Banji banji);

}
