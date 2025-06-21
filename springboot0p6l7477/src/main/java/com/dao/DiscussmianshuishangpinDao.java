package com.dao;

import com.entity.DiscussmianshuishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmianshuishangpinVO;
import com.entity.view.DiscussmianshuishangpinView;


/**
 * 宠物信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-11-17 16:56:58
 */
public interface DiscussmianshuishangpinDao extends BaseMapper<DiscussmianshuishangpinEntity> {
	
	List<DiscussmianshuishangpinVO> selectListVO(@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);
	
	DiscussmianshuishangpinVO selectVO(@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);
	
	List<DiscussmianshuishangpinView> selectListView(@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);

	List<DiscussmianshuishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);
	
	DiscussmianshuishangpinView selectView(@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);
	

}
