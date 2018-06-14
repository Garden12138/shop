package com.garden.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garden.web.dao.GoodsDao;
import com.garden.web.entity.GoodsEntity;
import com.garden.web.utils.Page;
import com.garden.web.utils.PageUtil;



@Repository
public class GoodsDaoImpl implements GoodsDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public void addGoods(GoodsEntity goodsEntity) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("GoodsDao.addGoods", goodsEntity);
	}


	@Override
	public int findTotal(String code) {
		// TODO Auto-generated method stub
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("codeLength", code.length());
		parameters.put("code", code);
		return sqlSessionTemplate.selectOne("GoodsDao.findTotal", parameters);
	}


	@Override
	public Page<GoodsEntity> findGoodsByCode(String code, int pageNumber, int prePage) {
		// TODO Auto-generated method stub
		Page<GoodsEntity> page = new Page<GoodsEntity>();
		Map<String,Object> parameters = new HashMap<String,Object>();
		long sum = this.findTotal(code);
		PageUtil.generatePage(page, sum, prePage, pageNumber);
		long startItem = prePage * (page.getPageNumber()-1);
		parameters.put("start", startItem);
		parameters.put("prePage", prePage);
		parameters.put("codeLength", code.length());
		parameters.put("code", code);
		List<GoodsEntity> goodsEntityList = sqlSessionTemplate.selectList("GoodsDao.findGoodsByCode", parameters);
		page.setPageData(goodsEntityList);
		return page;
	}

}
