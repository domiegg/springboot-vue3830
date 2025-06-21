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


import com.dao.DiscussmianshuishangpinDao;
import com.entity.DiscussmianshuishangpinEntity;
import com.service.DiscussmianshuishangpinService;
import com.entity.vo.DiscussmianshuishangpinVO;
import com.entity.view.DiscussmianshuishangpinView;

@Service("discussmianshuishangpinService")
public class DiscussmianshuishangpinServiceImpl extends ServiceImpl<DiscussmianshuishangpinDao, DiscussmianshuishangpinEntity> implements DiscussmianshuishangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmianshuishangpinEntity> page = this.selectPage(
                new Query<DiscussmianshuishangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussmianshuishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmianshuishangpinEntity> wrapper) {
		  Page<DiscussmianshuishangpinView> page =new Query<DiscussmianshuishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmianshuishangpinVO> selectListVO(Wrapper<DiscussmianshuishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmianshuishangpinVO selectVO(Wrapper<DiscussmianshuishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmianshuishangpinView> selectListView(Wrapper<DiscussmianshuishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmianshuishangpinView selectView(Wrapper<DiscussmianshuishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
