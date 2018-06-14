package com.garden.web.service;

import java.util.List;

import com.garden.web.entity.GoodsEntity;
import com.garden.web.entity.GoodsTypeEntity;
import com.garden.web.utils.Page;

/**
 * 首页服务层
 * @author Garden
 * 2018年6月12日
 */
public interface FrontPageService {
	
	/**
	 * 获取一级商品类型目录
	 * @return
	 */
	List<GoodsTypeEntity> getFirstLevelGoodsTypeCatalog();
	
	/**
	 * 根据商品类型代码获取二级商品类型目录
	 * @param code
	 * @return
	 */
	List<GoodsTypeEntity> getSecondLevelGoodsTypeCatalogByCode(String code);
	
	/**
	 * 根据商品类型代码分页商品记录
	 * @param code
	 * @param pageNumber
	 * @param prePage
	 * @return
	 */
	Page<GoodsEntity> getGoodsByCode(String code,int pageNumber,int prePage);
}
