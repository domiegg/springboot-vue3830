package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshuishangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MianshuishangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshuishangpinView;


/**
 * 宠物信息
 *
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface MianshuishangpinService extends IService<MianshuishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshuishangpinVO> selectListVO(Wrapper<MianshuishangpinEntity> wrapper);
   	
   	MianshuishangpinVO selectVO(@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);
   	
   	List<MianshuishangpinView> selectListView(Wrapper<MianshuishangpinEntity> wrapper);
   	
   	MianshuishangpinView selectView(@Param("ew") Wrapper<MianshuishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshuishangpinEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<MianshuishangpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<MianshuishangpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<MianshuishangpinEntity> wrapper);



}

