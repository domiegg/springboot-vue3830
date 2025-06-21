package com.dao;

import com.entity.ZixunshangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZixunshangjiaVO;
import com.entity.view.ZixunshangjiaView;


/**
 * 咨询商家
 * 
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface ZixunshangjiaDao extends BaseMapper<ZixunshangjiaEntity> {
	
	List<ZixunshangjiaVO> selectListVO(@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);
	
	ZixunshangjiaVO selectVO(@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);
	
	List<ZixunshangjiaView> selectListView(@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);

	List<ZixunshangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);
	
	ZixunshangjiaView selectView(@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);
	

}
