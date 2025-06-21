package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussmianshuishangpinEntity;
import com.entity.view.DiscussmianshuishangpinView;

import com.service.DiscussmianshuishangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宠物信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-17 16:56:58
 */
@RestController
@RequestMapping("/discussmianshuishangpin")
public class DiscussmianshuishangpinController {
    @Autowired
    private DiscussmianshuishangpinService discussmianshuishangpinService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussmianshuishangpinEntity discussmianshuishangpin,
		HttpServletRequest request){
        EntityWrapper<DiscussmianshuishangpinEntity> ew = new EntityWrapper<DiscussmianshuishangpinEntity>();

		PageUtils page = discussmianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmianshuishangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussmianshuishangpinEntity discussmianshuishangpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussmianshuishangpinEntity> ew = new EntityWrapper<DiscussmianshuishangpinEntity>();

		PageUtils page = discussmianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmianshuishangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussmianshuishangpinEntity discussmianshuishangpin){
       	EntityWrapper<DiscussmianshuishangpinEntity> ew = new EntityWrapper<DiscussmianshuishangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussmianshuishangpin, "discussmianshuishangpin")); 
        return R.ok().put("data", discussmianshuishangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussmianshuishangpinEntity discussmianshuishangpin){
        EntityWrapper< DiscussmianshuishangpinEntity> ew = new EntityWrapper< DiscussmianshuishangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussmianshuishangpin, "discussmianshuishangpin")); 
		DiscussmianshuishangpinView discussmianshuishangpinView =  discussmianshuishangpinService.selectView(ew);
		return R.ok("查询宠物信息评论表成功").put("data", discussmianshuishangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussmianshuishangpinEntity discussmianshuishangpin = discussmianshuishangpinService.selectById(id);
        return R.ok().put("data", discussmianshuishangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussmianshuishangpinEntity discussmianshuishangpin = discussmianshuishangpinService.selectById(id);
        return R.ok().put("data", discussmianshuishangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussmianshuishangpinEntity discussmianshuishangpin, HttpServletRequest request){
    	discussmianshuishangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussmianshuishangpin);
        discussmianshuishangpinService.insert(discussmianshuishangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussmianshuishangpinEntity discussmianshuishangpin, HttpServletRequest request){
    	discussmianshuishangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussmianshuishangpin);
        discussmianshuishangpinService.insert(discussmianshuishangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussmianshuishangpinEntity discussmianshuishangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmianshuishangpin);
        discussmianshuishangpinService.updateById(discussmianshuishangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussmianshuishangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussmianshuishangpinEntity discussmianshuishangpin, HttpServletRequest request,String pre){
        EntityWrapper<DiscussmianshuishangpinEntity> ew = new EntityWrapper<DiscussmianshuishangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussmianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmianshuishangpin), params), params));
        return R.ok().put("data", page);
    }










}
