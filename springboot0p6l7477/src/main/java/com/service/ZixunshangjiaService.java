package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZixunshangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZixunshangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunshangjiaView;


/**
 * 咨询商家
 *
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public interface ZixunshangjiaService extends IService<ZixunshangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunshangjiaVO> selectListVO(Wrapper<ZixunshangjiaEntity> wrapper);
   	
   	ZixunshangjiaVO selectVO(@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);
   	
   	List<ZixunshangjiaView> selectListView(Wrapper<ZixunshangjiaEntity> wrapper);
   	
   	ZixunshangjiaView selectView(@Param("ew") Wrapper<ZixunshangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunshangjiaEntity> wrapper);
   	

}

