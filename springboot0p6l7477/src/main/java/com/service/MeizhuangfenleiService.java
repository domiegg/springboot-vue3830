package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeizhuangfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeizhuangfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeizhuangfenleiView;


/**
 * 宠物分类
 *
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface MeizhuangfenleiService extends IService<MeizhuangfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeizhuangfenleiVO> selectListVO(Wrapper<MeizhuangfenleiEntity> wrapper);
   	
   	MeizhuangfenleiVO selectVO(@Param("ew") Wrapper<MeizhuangfenleiEntity> wrapper);
   	
   	List<MeizhuangfenleiView> selectListView(Wrapper<MeizhuangfenleiEntity> wrapper);
   	
   	MeizhuangfenleiView selectView(@Param("ew") Wrapper<MeizhuangfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeizhuangfenleiEntity> wrapper);
   	

}

