package com.entity.view;

import com.entity.DiscussmianshuishangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 宠物信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-11-17 16:56:58
 */
@TableName("discussmianshuishangpin")
public class DiscussmianshuishangpinView  extends DiscussmianshuishangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmianshuishangpinView(){
	}
 
 	public DiscussmianshuishangpinView(DiscussmianshuishangpinEntity discussmianshuishangpinEntity){
 	try {
			BeanUtils.copyProperties(this, discussmianshuishangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
