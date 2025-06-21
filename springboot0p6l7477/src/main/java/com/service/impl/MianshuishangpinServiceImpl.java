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


import com.dao.MianshuishangpinDao;
import com.entity.MianshuishangpinEntity;
import com.service.MianshuishangpinService;
import com.entity.vo.MianshuishangpinVO;
import com.entity.view.MianshuishangpinView;

@Service("mianshuishangpinService")
public class MianshuishangpinServiceImpl extends ServiceImpl<MianshuishangpinDao, MianshuishangpinEntity> implements MianshuishangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshuishangpinEntity> page = this.selectPage(
                new Query<MianshuishangpinEntity>(params).getPage(),
                new EntityWrapper<MianshuishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshuishangpinEntity> wrapper) {
		  Page<MianshuishangpinView> page =new Query<MianshuishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MianshuishangpinVO> selectListVO(Wrapper<MianshuishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshuishangpinVO selectVO(Wrapper<MianshuishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshuishangpinView> selectListView(Wrapper<MianshuishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshuishangpinView selectView(Wrapper<MianshuishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<MianshuishangpinEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<MianshuishangpinEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<MianshuishangpinEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
