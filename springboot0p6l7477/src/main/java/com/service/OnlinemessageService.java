package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.OnlinemessageEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.OnlinemessageVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.OnlinemessageView;


/**
 * 在线留言
 *
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface OnlinemessageService extends IService<OnlinemessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<OnlinemessageVO> selectListVO(Wrapper<OnlinemessageEntity> wrapper);
   	
   	OnlinemessageVO selectVO(@Param("ew") Wrapper<OnlinemessageEntity> wrapper);
   	
   	List<OnlinemessageView> selectListView(Wrapper<OnlinemessageEntity> wrapper);
   	
   	OnlinemessageView selectView(@Param("ew") Wrapper<OnlinemessageEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<OnlinemessageEntity> wrapper);
   	

}

