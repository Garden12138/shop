package com.garden.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garden.web.dao.GoodsTypeDao;
import com.garden.web.entity.GoodsTypeEntity;

@Repository
public class GoodsTypeDaoImpl implements GoodsTypeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void addGoodsType(GoodsTypeEntity goodsTypeEntity) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("GoodsTypeDao.addGoodsType", goodsTypeEntity);
	}

	@Override
	public List<GoodsTypeEntity> findGoodsTypesByLevel(int level) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("GoodsTypeDao.findGoodsTypesByLevel", level);
	}

	@Override
	public List<GoodsTypeEntity> findSecondGoodsTypesByCode(String code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("GoodsTypeDao.findSecondGoodsTypesByCode", code);
	}

}
