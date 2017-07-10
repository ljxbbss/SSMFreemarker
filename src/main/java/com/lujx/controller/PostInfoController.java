package com.lujx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lujx.entity.PostInfo;
import com.lujx.service.PostInfoService;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年6月21日
 */
@Controller
@RequestMapping("/post")
public class PostInfoController {

	@Autowired
	PostInfoService piService;

	@RequestMapping("/getShopsDetailInfo")
	@ResponseBody
	public Map<String, Object> getShopsDetailInfo(String shopId, String language) {
		Map<String, Object> map = new HashMap<String, Object>();
		PostInfo loadById = piService.loadById(2);
		map.put("post", loadById);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@RequestBody PostInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("post", info);
		return map;
	}

}
