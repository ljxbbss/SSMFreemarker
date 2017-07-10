package com.lujx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lujx.entity.PostInfo;
import com.lujx.mapper.PostInfoMapper;
import com.lujx.service.PostInfoService;

/** 
 * @author  Lujx  🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年6月21日
 */
@Transactional
@Service
public class PostInfoServiceImpl implements PostInfoService{
	@Autowired
	PostInfoMapper postInfoMapper;

	@Override
	public PostInfo loadById(Integer id) {
		return postInfoMapper.selectByPrimaryKey(id);
	}

}


