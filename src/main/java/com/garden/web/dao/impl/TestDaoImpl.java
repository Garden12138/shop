package com.garden.web.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.garden.web.dao.TestDao;
import com.garden.web.entity.TestEntity;
@Repository
public class TestDaoImpl implements TestDao{
	
	@Resource
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void addTestEntity(TestEntity testEntity) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("TestDao.addTestEntity",testEntity);
	}

}
