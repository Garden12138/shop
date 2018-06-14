package com.garden.web.utils.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.garden.web.config.UtilsConfig;
import com.garden.web.utils.PictureGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=UtilsConfig.class)
public class PictureGeneratorTest {

	@Autowired
	private PictureGenerator pictureGenerator;
	
	@Test
	public void test() {
		System.out.println("PictureGeneratorTesting...");
	}
	
	@Test
	public void getDownloadUrlTest(){
		System.out.println(pictureGenerator.getDownloadUrl());
	}

}
