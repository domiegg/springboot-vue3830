package com.entity.vo;

import com.entity.OnlinemessageEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 在线留言
 * 商品端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-11-17 16:56:57
 */
public class OnlinemessageVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 邮箱
	 */
	
	private String email;
		
	/**
	 * 电话
	 */
	
	private String mobile;
		
	/**
	 * 留言内容
	 */
	
	private String content;
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
				
	
	/**
	 * 设置：电话
	 */
	 
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取：电话
	 */
	public String getMobile() {
		return mobile;
	}
				
	
	/**
	 * 设置：留言内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：留言内容
	 */
	public String getContent() {
		return content;
	}
			
}
