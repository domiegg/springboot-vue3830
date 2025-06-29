package com.dao;

import com.entity.TongzhigonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TongzhigonggaoVO;
import com.entity.view.TongzhigonggaoView;


/**
 * 通知公告
 * 
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface TongzhigonggaoDao extends BaseMapper<TongzhigonggaoEntity> {
	
	List<TongzhigonggaoVO> selectListVO(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	TongzhigonggaoVO selectVO(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	List<TongzhigonggaoView> selectListView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);

	List<TongzhigonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	TongzhigonggaoView selectView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	

}
