package com.sxt.sys.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActCommentEntity {

	private String userId;//批注 人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date time;//批注时间
	private String message;//批注内容
	private String fullMessage;//批注内容
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFullMessage() {
		return fullMessage;
	}
	public void setFullMessage(String fullMessage) {
		this.fullMessage = fullMessage;
	}
	
	

}
