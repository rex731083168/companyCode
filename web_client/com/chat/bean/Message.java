package com.chat.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 传输信息对象
 * 
 * @author admin
 *
 */
public class Message {
	private int infoType;// 信息类型 （1私聊 0上下线更新 -1下线请求 2请求发送文件 3.确定接收文件）
	private HashSet<String> clients;// 需要发送的在线用户
	private HashMap<String, User> users;// 在线用户
	private Date time;// 发送消息的时间
	private String info;// 发送的消息
	private String name;// 消息发送方姓名
	private String fileName;// 发送文件名字
	private long size;// 文件大小
	private String ip;// 发送方ip地址
	private long port;// 发送方端口号

	public int getInfoType() {
		return infoType;
	}

	public void setInfoType(int infoType) {
		this.infoType = infoType;
	}

	public HashSet<String> getClients() {
		return clients;
	}

	public void setClients(HashSet<String> clients) {
		this.clients = clients;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getPort() {
		return port;
	}

	public void setPort(long port) {
		this.port = port;
	}

}
