package com.situ.ssm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.situ.ssm.dao.IBanjiDao;
import com.situ.ssm.entity.Banji;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.util.MyBatisUtil;
import com.situ.ssm.vo.PageBean;

public class BanjiServiceImpl implements IBanjiService{
	private IBanjiDao banjiDao = null;
	public BanjiServiceImpl() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		banjiDao = sqlSession.getMapper(IBanjiDao.class);
	}
	
	/**
	 *	
	 */
	@Override
	public PageBean<Banji> getPageBean(Integer pageNo, Integer pageSize) {
		PageBean<Banji> pageBean = new PageBean<>();
		// 当前是第几页
		pageBean.setPageNo(pageNo);
		// 一页有多少条数据
		pageBean.setPageSize(pageSize);
		// 总记录数
		int totalCount = banjiDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		// 一共有多少页,向上取整
		int totalPage = (int) Math.ceil((double) totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		// 当前页的数据
		int offset = (pageNo - 1) * pageSize;
		List<Banji> list = banjiDao.pageList(offset, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
