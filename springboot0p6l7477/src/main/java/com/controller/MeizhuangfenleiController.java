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

import com.entity.MeizhuangfenleiEntity;
import com.entity.view.MeizhuangfenleiView;

import com.service.MeizhuangfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宠物分类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
@RestController
@RequestMapping("/meizhuangfenlei")
public class MeizhuangfenleiController {
    @Autowired
    private MeizhuangfenleiService meizhuangfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeizhuangfenleiEntity meizhuangfenlei,
		HttpServletRequest request){
        EntityWrapper<MeizhuangfenleiEntity> ew = new EntityWrapper<MeizhuangfenleiEntity>();

		PageUtils page = meizhuangfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meizhuangfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeizhuangfenleiEntity meizhuangfenlei, 
		HttpServletRequest request){
        EntityWrapper<MeizhuangfenleiEntity> ew = new EntityWrapper<MeizhuangfenleiEntity>();

		PageUtils page = meizhuangfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meizhuangfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeizhuangfenleiEntity meizhuangfenlei){
       	EntityWrapper<MeizhuangfenleiEntity> ew = new EntityWrapper<MeizhuangfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meizhuangfenlei, "meizhuangfenlei")); 
        return R.ok().put("data", meizhuangfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeizhuangfenleiEntity meizhuangfenlei){
        EntityWrapper< MeizhuangfenleiEntity> ew = new EntityWrapper< MeizhuangfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meizhuangfenlei, "meizhuangfenlei")); 
		MeizhuangfenleiView meizhuangfenleiView =  meizhuangfenleiService.selectView(ew);
		return R.ok("查询宠物分类成功").put("data", meizhuangfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeizhuangfenleiEntity meizhuangfenlei = meizhuangfenleiService.selectById(id);
        return R.ok().put("data", meizhuangfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeizhuangfenleiEntity meizhuangfenlei = meizhuangfenleiService.selectById(id);
        return R.ok().put("data", meizhuangfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeizhuangfenleiEntity meizhuangfenlei, HttpServletRequest request){
    	meizhuangfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meizhuangfenlei);
        meizhuangfenleiService.insert(meizhuangfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeizhuangfenleiEntity meizhuangfenlei, HttpServletRequest request){
    	meizhuangfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meizhuangfenlei);
        meizhuangfenleiService.insert(meizhuangfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MeizhuangfenleiEntity meizhuangfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meizhuangfenlei);
        meizhuangfenleiService.updateById(meizhuangfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meizhuangfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
