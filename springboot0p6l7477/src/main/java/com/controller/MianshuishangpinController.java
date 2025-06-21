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
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.MianshuishangpinEntity;
import com.entity.view.MianshuishangpinView;

import com.service.MianshuishangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 宠物信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
@RestController
@RequestMapping("/mianshuishangpin")
public class MianshuishangpinController {
    @Autowired
    private MianshuishangpinService mianshuishangpinService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MianshuishangpinEntity mianshuishangpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			mianshuishangpin.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = mianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshuishangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MianshuishangpinEntity mianshuishangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = mianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshuishangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MianshuishangpinEntity mianshuishangpin){
       	EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mianshuishangpin, "mianshuishangpin")); 
        return R.ok().put("data", mianshuishangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MianshuishangpinEntity mianshuishangpin){
        EntityWrapper< MianshuishangpinEntity> ew = new EntityWrapper< MianshuishangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mianshuishangpin, "mianshuishangpin")); 
		MianshuishangpinView mianshuishangpinView =  mianshuishangpinService.selectView(ew);
		return R.ok("查询宠物信息成功").put("data", mianshuishangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MianshuishangpinEntity mianshuishangpin = mianshuishangpinService.selectById(id);
		mianshuishangpin.setClicknum(mianshuishangpin.getClicknum()+1);
		mianshuishangpin.setClicktime(new Date());
		mianshuishangpinService.updateById(mianshuishangpin);
        return R.ok().put("data", mianshuishangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MianshuishangpinEntity mianshuishangpin = mianshuishangpinService.selectById(id);
		mianshuishangpin.setClicknum(mianshuishangpin.getClicknum()+1);
		mianshuishangpin.setClicktime(new Date());
		mianshuishangpinService.updateById(mianshuishangpin);
        return R.ok().put("data", mianshuishangpin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        MianshuishangpinEntity mianshuishangpin = mianshuishangpinService.selectById(id);
        if(type.equals("1")) {
        	mianshuishangpin.setThumbsupnum(mianshuishangpin.getThumbsupnum()+1);
        } else {
        	mianshuishangpin.setCrazilynum(mianshuishangpin.getCrazilynum()+1);
        }
        mianshuishangpinService.updateById(mianshuishangpin);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MianshuishangpinEntity mianshuishangpin, HttpServletRequest request){
    	mianshuishangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mianshuishangpin);
        mianshuishangpinService.insert(mianshuishangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MianshuishangpinEntity mianshuishangpin, HttpServletRequest request){
    	mianshuishangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mianshuishangpin);
        mianshuishangpinService.insert(mianshuishangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MianshuishangpinEntity mianshuishangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshuishangpin);
        mianshuishangpinService.updateById(mianshuishangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mianshuishangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MianshuishangpinEntity mianshuishangpin, HttpServletRequest request,String pre){
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = mianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshuishangpin), params), params));
        return R.ok().put("data", page);
    }


        /**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,MianshuishangpinEntity mianshuishangpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "meizhuangfenlei";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "mianshuishangpin").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<MianshuishangpinEntity> mianshuishangpinList = new ArrayList<MianshuishangpinEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        mianshuishangpinList.addAll(mianshuishangpinService.selectList(new EntityWrapper<MianshuishangpinEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = mianshuishangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshuishangpin), params), params));
        List<MianshuishangpinEntity> pageList = (List<MianshuishangpinEntity>)page.getList();
        if(mianshuishangpinList.size()<limit) {
                int toAddNum = (limit-mianshuishangpinList.size())<=pageList.size()?(limit-mianshuishangpinList.size()):pageList.size();
                for(MianshuishangpinEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(MianshuishangpinEntity o2 : mianshuishangpinList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        mianshuishangpinList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(mianshuishangpinList.size()>limit) {
            mianshuishangpinList = mianshuishangpinList.subList(0, limit);
        }
        page.setList(mianshuishangpinList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
            ew.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = mianshuishangpinService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shangjia")) {
            ew.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = mianshuishangpinService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shangjia")) {
            ew.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = mianshuishangpinService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shangjia")) {
            ew.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = mianshuishangpinService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shangjia")) {
            ew.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = mianshuishangpinService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,MianshuishangpinEntity mianshuishangpin, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shangjia")) {
            mianshuishangpin.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<MianshuishangpinEntity> ew = new EntityWrapper<MianshuishangpinEntity>();
        int count = mianshuishangpinService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshuishangpin), params), params));
        return R.ok().put("data", count);
    }



}
