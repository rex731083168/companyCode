package com.chat.bean;

import java.net.Socket;
/**
 * socket请求类
 * @author admin
 *
 */
public class User {
	private String name;// 登录名
	private Socket socket;// socket请求

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
