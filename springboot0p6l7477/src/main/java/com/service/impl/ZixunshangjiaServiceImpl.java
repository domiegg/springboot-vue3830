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


import com.dao.ZixunshangjiaDao;
import com.entity.ZixunshangjiaEntity;
import com.service.ZixunshangjiaService;
import com.entity.vo.ZixunshangjiaVO;
import com.entity.view.ZixunshangjiaView;

@Service("zixunshangjiaService")
public class ZixunshangjiaServiceImpl extends ServiceImpl<ZixunshangjiaDao, ZixunshangjiaEntity> implements ZixunshangjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunshangjiaEntity> page = this.selectPage(
                new Query<ZixunshangjiaEntity>(params).getPage(),
                new EntityWrapper<ZixunshangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunshangjiaEntity> wrapper) {
		  Page<ZixunshangjiaView> page =new Query<ZixunshangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZixunshangjiaVO> selectListVO(Wrapper<ZixunshangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZixunshangjiaVO selectVO(Wrapper<ZixunshangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZixunshangjiaView> selectListView(Wrapper<ZixunshangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunshangjiaView selectView(Wrapper<ZixunshangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
