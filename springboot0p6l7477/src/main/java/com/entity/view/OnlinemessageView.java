package com.entity.view;

import com.entity.OnlinemessageEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 在线留言
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
@TableName("onlinemessage")
public class OnlinemessageView  extends OnlinemessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OnlinemessageView(){
	}
 
 	public OnlinemessageView(OnlinemessageEntity onlinemessageEntity){
 	try {
			BeanUtils.copyProperties(this, onlinemessageEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
