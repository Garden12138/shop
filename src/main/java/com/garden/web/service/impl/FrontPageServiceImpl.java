package com.garden.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.web.dao.GoodsTypeDao;
import com.garden.web.dao.GoodsDao;
import com.garden.web.entity.GoodsEntity;
import com.garden.web.entity.GoodsTypeEntity;
import com.garden.web.service.FrontPageService;
import com.garden.web.utils.Page;
import com.garden.web.utils.PictureGenerator;
@Service
public class FrontPageServiceImpl implements FrontPageService{

	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private PictureGenerator pictureGenerator;
	
	@Override
	public List<GoodsTypeEntity> getFirstLevelGoodsTypeCatalog() {
		// TODO Auto-generated method stub
		return goodsTypeDao.findGoodsTypesByLevel(1);
	}

	@Override
	public List<GoodsTypeEntity> getSecondLevelGoodsTypeCatalogByCode(String code) {
		// TODO Auto-generated method stub
		return goodsTypeDao.findSecondGoodsTypesByCode(code);
	}

	@Override
	public Page<GoodsEntity> getGoodsByCode(String code, int pageNumber, int prePage) {
		// TODO Auto-generated method stub
		Page<GoodsEntity> page = goodsDao.findGoodsByCode(code, pageNumber, prePage);
		List<GoodsEntity> goodsEntityList = page.getPageData();
		if(null != goodsEntityList){
			for(GoodsEntity goodsEntity : goodsEntityList){
				goodsEntity.setImage(pictureGenerator.getDownloadUrl()+goodsEntity.getImage());
			}
		}
		page.setPageData(goodsEntityList);
		return page;
	}

}
