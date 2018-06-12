package com.garden.web.utils.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.garden.web.config.UtilsConfig;
import com.garden.web.utils.UUIDGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=UtilsConfig.class)
public class UUIDGeneratorTest {

	@Autowired
	private UUIDGenerator uuIDGenerator;
	
	@Test
	public void test() {
		System.out.println("UUIDGeneratorTesting...");
	}
	
	@Test
	public void generateUUID(){
		System.out.println(uuIDGenerator.generateUUID());
	}

}
