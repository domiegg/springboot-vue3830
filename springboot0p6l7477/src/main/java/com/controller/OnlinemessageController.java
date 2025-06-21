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

import com.entity.OnlinemessageEntity;
import com.entity.view.OnlinemessageView;

import com.service.OnlinemessageService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 在线留言
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
@RestController
@RequestMapping("/onlinemessage")
public class OnlinemessageController {
    @Autowired
    private OnlinemessageService onlinemessageService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,OnlinemessageEntity onlinemessage,
		HttpServletRequest request){
        EntityWrapper<OnlinemessageEntity> ew = new EntityWrapper<OnlinemessageEntity>();

		PageUtils page = onlinemessageService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, onlinemessage), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,OnlinemessageEntity onlinemessage, 
		HttpServletRequest request){
        EntityWrapper<OnlinemessageEntity> ew = new EntityWrapper<OnlinemessageEntity>();

		PageUtils page = onlinemessageService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, onlinemessage), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( OnlinemessageEntity onlinemessage){
       	EntityWrapper<OnlinemessageEntity> ew = new EntityWrapper<OnlinemessageEntity>();
      	ew.allEq(MPUtil.allEQMapPre( onlinemessage, "onlinemessage")); 
        return R.ok().put("data", onlinemessageService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(OnlinemessageEntity onlinemessage){
        EntityWrapper< OnlinemessageEntity> ew = new EntityWrapper< OnlinemessageEntity>();
 		ew.allEq(MPUtil.allEQMapPre( onlinemessage, "onlinemessage")); 
		OnlinemessageView onlinemessageView =  onlinemessageService.selectView(ew);
		return R.ok("查询在线留言成功").put("data", onlinemessageView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        OnlinemessageEntity onlinemessage = onlinemessageService.selectById(id);
        return R.ok().put("data", onlinemessage);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        OnlinemessageEntity onlinemessage = onlinemessageService.selectById(id);
        return R.ok().put("data", onlinemessage);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OnlinemessageEntity onlinemessage, HttpServletRequest request){
    	onlinemessage.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(onlinemessage);
        onlinemessageService.insert(onlinemessage);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody OnlinemessageEntity onlinemessage, HttpServletRequest request){
    	onlinemessage.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(onlinemessage);
        onlinemessageService.insert(onlinemessage);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody OnlinemessageEntity onlinemessage, HttpServletRequest request){
        //ValidatorUtils.validateEntity(onlinemessage);
        onlinemessageService.updateById(onlinemessage);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        onlinemessageService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,OnlinemessageEntity onlinemessage, HttpServletRequest request,String pre){
        EntityWrapper<OnlinemessageEntity> ew = new EntityWrapper<OnlinemessageEntity>();
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
		PageUtils page = onlinemessageService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, onlinemessage), params), params));
        return R.ok().put("data", page);
    }










}
