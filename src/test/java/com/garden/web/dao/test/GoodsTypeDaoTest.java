package com.garden.web.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.garden.web.config.RootConfig;
import com.garden.web.dao.GoodsTypeDao;
import com.garden.web.dao.TestDao;
import com.garden.web.entity.GoodsTypeEntity;
import com.garden.web.entity.TestEntity;
import com.garden.web.utils.UUIDGenerator;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class GoodsTypeDaoTest {

	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@Autowired
	private UUIDGenerator uuIDGenerator;
	
	@Test
	public void test() {
		System.out.println("GoodsTypeDaoTesting...");
		String str = "GoodsTypeDao,TestDao,";
		String args[] = str.split(",");
		for(String arg : args){
			System.out.println(arg.toString());
		}
	}
	
	@Test
	public void addGoodsTypeTest(){
		String uuid = uuIDGenerator.generateUUID();
		GoodsTypeEntity goodsTypeEntity = new GoodsTypeEntity();
		goodsTypeEntity.setId(uuid);
		goodsTypeEntity.setName("内衣");
		goodsTypeEntity.setRemark("underwear");
		goodsTypeEntity.setCode("9003");
		goodsTypeEntity.setLevel(1);
		goodsTypeDao.addGoodsType(goodsTypeEntity);
	}

	@Test
	public void addGoodsTypesTest(){
		for(int i = 0; i < 9; i++){
			goodsTypeDao.addGoodsType(new GoodsTypeEntity(
					uuIDGenerator.generateUUID()
					,"法式内衣_"+String.valueOf(i)
					,"9003000"+String.valueOf(i)
					,"underwear_"+String.valueOf(i),2));
		}
	}
	
	@Test
	public void getFirstGoodsCatalogTest(){
		List<GoodsTypeEntity> goodsTypeList = goodsTypeDao.findGoodsTypesByLevel(6);
		if(null != goodsTypeList){
			for(GoodsTypeEntity goodsType:goodsTypeList){
				System.out.println(goodsType);
			}
		}
	}
	
	@Test
	public void findSecondGoodsTypesByCodeTest(){
		List<GoodsTypeEntity> goodsTypeList = goodsTypeDao.findSecondGoodsTypesByCode("9001");
		if(null != goodsTypeList){
			for(GoodsTypeEntity goodsType:goodsTypeList){
				System.out.println(goodsType);
			}
		}
	}
}
