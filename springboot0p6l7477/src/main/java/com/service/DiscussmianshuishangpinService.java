package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmianshuishangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmianshuishangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmianshuishangpinView;


/**
 * 宠物信息评论表
 *
 * @author 
 * @email 
 * @date 2023-11-17 16:56:58
 */
public interface DiscussmianshuishangpinService extends IService<DiscussmianshuishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmianshuishangpinVO> selectListVO(Wrapper<DiscussmianshuishangpinEntity> wrapper);
   	
   	DiscussmianshuishangpinVO selectVO(@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);
   	
   	List<DiscussmianshuishangpinView> selectListView(Wrapper<DiscussmianshuishangpinEntity> wrapper);
   	
   	DiscussmianshuishangpinView selectView(@Param("ew") Wrapper<DiscussmianshuishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmianshuishangpinEntity> wrapper);
   	

}

