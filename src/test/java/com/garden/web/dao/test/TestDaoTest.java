package com.garden.web.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.garden.web.config.RootConfig;
import com.garden.web.dao.TestDao;
import com.garden.web.entity.TestEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class TestDaoTest {

	@Autowired
	private TestDao testDao;
	
	@Test
	public void test() {
		System.out.println("TestDaoTesting...");
	}
	
	@Test
	public void addTestEntityTest(){
		TestEntity testEntity = new TestEntity();
		testEntity.setId(3);
		testEntity.setMessage("id is 1 record");
		testDao.addTestEntity(testEntity);
	}

}
