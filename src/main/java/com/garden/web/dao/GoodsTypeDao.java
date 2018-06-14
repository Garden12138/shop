package com.garden.web.dao;

import java.util.List;

import com.garden.web.entity.GoodsTypeEntity;
/**
 * 商品类型记录数据操作层
 * @author Garden
 * 2018年6月12日
 */
public interface GoodsTypeDao {
	/**
	 * 添加一条商品类型记录
	 * @param goodsTypeEntity
	 */
	void addGoodsType(GoodsTypeEntity goodsTypeEntity);
	/**
	 * 获取相应级别商品类型记录
	 * @param level
	 * @return
	 */
	List<GoodsTypeEntity> findGoodsTypesByLevel(int level);
	
	/**
	 * 根据商品类型代码获取二级商品类型记录
	 * @param code
	 * @return
	 */
	List<GoodsTypeEntity> findSecondGoodsTypesByCode(String code);
}
