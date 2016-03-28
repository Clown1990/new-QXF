package com.qxjs.model.vo.common;

public class MessageVo
{
	private String msgName;
	private Object msgValue;
	private Object msgBody;
	private String msgType;
	
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public Object getMsgValue() {
		return msgValue;
	}
	public void setMsgValue(Object msgValue) {
		this.msgValue = msgValue;
	}
	public Object getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(Object msgBody) {
		this.msgBody = msgBody;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
