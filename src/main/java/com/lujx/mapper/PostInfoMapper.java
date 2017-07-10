package com.lujx.mapper;

import com.lujx.entity.PostInfo;
import java.util.List;

public interface PostInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostInfo record);

    PostInfo selectByPrimaryKey(Integer id);

    List<PostInfo> selectAll();

    int updateByPrimaryKey(PostInfo record);
}