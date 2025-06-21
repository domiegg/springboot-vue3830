package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.OnlinemessageDao;
import com.entity.OnlinemessageEntity;
import com.service.OnlinemessageService;
import com.entity.vo.OnlinemessageVO;
import com.entity.view.OnlinemessageView;

@Service("onlinemessageService")
public class OnlinemessageServiceImpl extends ServiceImpl<OnlinemessageDao, OnlinemessageEntity> implements OnlinemessageService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OnlinemessageEntity> page = this.selectPage(
                new Query<OnlinemessageEntity>(params).getPage(),
                new EntityWrapper<OnlinemessageEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<OnlinemessageEntity> wrapper) {
		  Page<OnlinemessageView> page =new Query<OnlinemessageView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<OnlinemessageVO> selectListVO(Wrapper<OnlinemessageEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public OnlinemessageVO selectVO(Wrapper<OnlinemessageEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<OnlinemessageView> selectListView(Wrapper<OnlinemessageEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public OnlinemessageView selectView(Wrapper<OnlinemessageEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
