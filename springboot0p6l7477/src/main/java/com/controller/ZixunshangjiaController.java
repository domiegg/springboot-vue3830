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

import com.entity.ZixunshangjiaEntity;
import com.entity.view.ZixunshangjiaView;

import com.service.ZixunshangjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询商家
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
@RestController
@RequestMapping("/zixunshangjia")
public class ZixunshangjiaController {
    @Autowired
    private ZixunshangjiaService zixunshangjiaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunshangjiaEntity zixunshangjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			zixunshangjia.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zixunshangjia.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunshangjiaEntity> ew = new EntityWrapper<ZixunshangjiaEntity>();

		PageUtils page = zixunshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunshangjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunshangjiaEntity zixunshangjia, 
		HttpServletRequest request){
        EntityWrapper<ZixunshangjiaEntity> ew = new EntityWrapper<ZixunshangjiaEntity>();

		PageUtils page = zixunshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunshangjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunshangjiaEntity zixunshangjia){
       	EntityWrapper<ZixunshangjiaEntity> ew = new EntityWrapper<ZixunshangjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunshangjia, "zixunshangjia")); 
        return R.ok().put("data", zixunshangjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunshangjiaEntity zixunshangjia){
        EntityWrapper< ZixunshangjiaEntity> ew = new EntityWrapper< ZixunshangjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunshangjia, "zixunshangjia")); 
		ZixunshangjiaView zixunshangjiaView =  zixunshangjiaService.selectView(ew);
		return R.ok("查询咨询商家成功").put("data", zixunshangjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunshangjiaEntity zixunshangjia = zixunshangjiaService.selectById(id);
        return R.ok().put("data", zixunshangjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunshangjiaEntity zixunshangjia = zixunshangjiaService.selectById(id);
        return R.ok().put("data", zixunshangjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunshangjiaEntity zixunshangjia, HttpServletRequest request){
    	zixunshangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunshangjia);
        zixunshangjiaService.insert(zixunshangjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZixunshangjiaEntity zixunshangjia, HttpServletRequest request){
    	zixunshangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunshangjia);
        zixunshangjiaService.insert(zixunshangjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZixunshangjiaEntity zixunshangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunshangjia);
        zixunshangjiaService.updateById(zixunshangjia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunshangjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
