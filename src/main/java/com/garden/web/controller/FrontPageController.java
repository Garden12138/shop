package com.garden.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.garden.web.entity.GoodsTypeEntity;
import com.garden.web.service.FrontPageService;

@Controller
@RequestMapping(value="/front")
public class FrontPageController {
	
	@Autowired
	private FrontPageService frontPageService;
	
	/**
	 * 初始化首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String getFrontPage(HttpServletRequest request,HttpServletResponse response){
		List<GoodsTypeEntity> goodsTypeEntityList = frontPageService.getFirstLevelGoodsTypeCatalog();
		request.getSession().setAttribute("FirstLevelGoodsTypeCatalog"
				, goodsTypeEntityList);
		request.getSession().setAttribute("SecondLevelGoodsTypeCatalogByCode"
				,frontPageService.getSecondLevelGoodsTypeCatalogByCode(goodsTypeEntityList.get(0).getCode()));
		request.getSession().setAttribute("Page", frontPageService.getGoodsByCode(goodsTypeEntityList.get(0).getCode(), 1, 8));
		return "list";
	}
}
