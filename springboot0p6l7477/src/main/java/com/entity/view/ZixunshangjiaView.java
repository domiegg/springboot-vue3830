package com.entity.view;

import com.entity.ZixunshangjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 咨询商家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
@TableName("zixunshangjia")
public class ZixunshangjiaView  extends ZixunshangjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZixunshangjiaView(){
	}
 
 	public ZixunshangjiaView(ZixunshangjiaEntity zixunshangjiaEntity){
 	try {
			BeanUtils.copyProperties(this, zixunshangjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
