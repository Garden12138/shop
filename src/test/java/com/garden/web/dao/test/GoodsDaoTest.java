package com.garden.web.dao.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.garden.web.config.RootConfig;
import com.garden.web.dao.GoodsDao;
import com.garden.web.dao.GoodsTypeDao;
import com.garden.web.dao.TestDao;
import com.garden.web.entity.GoodsEntity;
import com.garden.web.entity.GoodsTypeEntity;
import com.garden.web.entity.TestEntity;
import com.garden.web.utils.Page;
import com.garden.web.utils.UUIDGenerator;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class GoodsDaoTest {

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private UUIDGenerator uuIDGenerator;
	
	@Test
	public void test() {
		System.out.println("GoodsDaoTestTesting...");
	}
	
	@Test
	public void addGoodsTest(){
		for(int i = 0; i < 9; i++){
			GoodsEntity goodsEntity = new GoodsEntity();
			goodsEntity.setId(uuIDGenerator.generateUUID());
			goodsEntity.setTitle("法式内衣_2_"+String.valueOf(i)+"的标题");
			goodsEntity.setDescription("法式内衣_2_"+String.valueOf(i)+"的描述");
			goodsEntity.setPrice(100.0+i);
			goodsEntity.setDiscount(0.98);
			goodsEntity.setLocality("法式内衣_2_"+String.valueOf(i)+"的生产地");
			goodsEntity.setCreateDate(new Date());
			goodsEntity.setSupplier("法式内衣_2_"+String.valueOf(i)+"的供应商");
			goodsEntity.setPutAwayDate(new Date());
			goodsEntity.setStorage(100);
			goodsEntity.setIsRemove(0);
			goodsEntity.setImage("法式内衣_2_"+String.valueOf(i)+".jpg");
			goodsEntity.setGoods_type_code("90030002");
			goodsDao.addGoods(goodsEntity);
		}
	}
	
	@Test
	public void findTotalTest(){
		System.out.println(goodsDao.findTotal("9001"));
	    System.out.println(goodsDao.findTotal("90010000"));
	}
	
	@Test
	public void findGoodsByCodeTest(){
		String code = "90010001";
		int pageNumber = 2;
		int prePage = 8;
		Page<GoodsEntity> page = goodsDao.findGoodsByCode(code, pageNumber, prePage);
		List<GoodsEntity> goodsEntityList = page.getPageData();
		if(null != goodsEntityList){
			for(GoodsEntity goodsEntity : goodsEntityList){
				System.out.println(goodsEntity.toString());
			}
		}
	}
}
