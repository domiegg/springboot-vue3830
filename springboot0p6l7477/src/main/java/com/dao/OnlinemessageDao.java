package com.dao;

import com.entity.OnlinemessageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.OnlinemessageVO;
import com.entity.view.OnlinemessageView;


/**
 * 在线留言
 * 
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface OnlinemessageDao extends BaseMapper<OnlinemessageEntity> {
	
	List<OnlinemessageVO> selectListVO(@Param("ew") Wrapper<OnlinemessageEntity> wrapper);
	
	OnlinemessageVO selectVO(@Param("ew") Wrapper<OnlinemessageEntity> wrapper);
	
	List<OnlinemessageView> selectListView(@Param("ew") Wrapper<OnlinemessageEntity> wrapper);

	List<OnlinemessageView> selectListView(Pagination page,@Param("ew") Wrapper<OnlinemessageEntity> wrapper);
	
	OnlinemessageView selectView(@Param("ew") Wrapper<OnlinemessageEntity> wrapper);
	

}
