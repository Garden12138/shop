package com.garden.web.dao;

import com.garden.web.entity.GoodsEntity;
import com.garden.web.utils.Page;

/**
 * 商品记录操作层
 * @author Garden
 * 2018年6月13日
 */
public interface GoodsDao {
	/**
	 * 添加单件商品
	 * @param goodsEntity
	 */
	void addGoods(GoodsEntity goodsEntity);
	
	/**
	 * 根据商品类型代码获取商品数量
	 * @param code
	 * @return
	 */
	int findTotal(String code);
	
	/**
	 * 根据商品类型代码分页获取商品记录
	 * @param code
	 * @param pageNumber
	 * @param prePage
	 * @return
	 */
	Page<GoodsEntity> findGoodsByCode(String code,int pageNumber,int prePage);
	
}
