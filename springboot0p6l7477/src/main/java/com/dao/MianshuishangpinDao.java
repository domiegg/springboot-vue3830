package com.dao;

import com.entity.MianshuishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MianshuishangpinVO;
import com.entity.view.MianshuishangpinView;


/**
 * 宠物信息
 * 
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface MianshuishangpinDao extends BaseMapper<MianshuishangpinEntity> {
	
	List<MianshuishangpinVO> selectListVO(@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);
	
	MianshuishangpinVO selectVO(@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);
	
	List<MianshuishangpinView> selectListView(@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);

	List<MianshuishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);
	
	MianshuishangpinView selectView(@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);



}
