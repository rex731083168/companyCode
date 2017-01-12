package com.chat.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.chat.bean.Message;
import com.chat.bean.User;

/**
 * 服务端类
 * 
 * @author admin
 *
 */
public class ChatServer {
	private static ServerSocket ss;
	public static HashMap<String, User> onlines;// 在线用户组
	private static final int PORT = 8530;// 端口号
	static {
		try {
			ss = new ServerSocket(PORT);// 设置端口号为8530
			System.out.println("服务器监听的端口号是: " + PORT);
			onlines = new HashMap<String, User>();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("该端口被占用或不允许访问");
		}
	}

	// 线程处理socket请求
	class chatThread implements Runnable {
		private Socket client;// 一个客户端请求
		private Message message;// 消息对象
		private ObjectInputStream ois;// 输入流，接收客户端发送的消息
		private ObjectOutputStream oos;// 输出流，将消息发送到客户端

		public chatThread(Socket client) {
			super();
			this.client = client;
		}

		@Override
		public void run() {
			try {
				// 不停的从客户端接收信息
				while (true) {
					ois = new ObjectInputStream(client.getInputStream());
					message = (Message) ois.readObject();
					// 分析消息是哪种类型的
					int type = message.getInfoType();
					// 创建服务器的Message，并发送给客户端
					Message serverMessage = new Message();
					switch (type) {
					case 0: {
						// 有人上线
						User user = new User();
						user.setName(message.getName());
						user.setSocket(client);
						// 将用户添加到在线用户组
						onlines.put(message.getName(), user);
						serverMessage.setInfoType(0);
						serverMessage.setInfo(message.getTime() + "欢迎" + message.getName());
						// 发送给所有人
						HashSet<String> names = new HashSet<>();
						names.addAll(onlines.keySet());
						sendAll(serverMessage);
						break;
					}

					case -1: {
						// 有人下线
						serverMessage.setInfoType(-1);
						try {
							oos = new ObjectOutputStream(client.getOutputStream());
							oos.writeObject(serverMessage);
							oos.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 移除下线人
						onlines.remove(message.getName());
						// 向剩下所有的用户通知下线人员
						Message serverMessage2 = new Message();
						serverMessage2.setInfo(message.getTime() + ",用户" + message.getName() + "下线");
						serverMessage2.setInfoType(-1);
						HashSet<String> names = new HashSet<>();
						names.addAll(onlines.keySet());
						sendAll(serverMessage2);
						return;
					}

					case 1: {
						serverMessage.setInfoType(1);
						serverMessage.setClients(message.getClients());
						serverMessage.setInfo(message.getInfo());
						serverMessage.setName(message.getName());
						serverMessage.setTime(message.getTime());
						sendMessage(serverMessage);
						break;
					}
					
					case 2:{
						
					}
					default:
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	// 发送信息给所有人
	private void sendAll(Message message) {
		Collection<User> clients = onlines.values();
		Iterator<User> it = clients.iterator();
		ObjectOutputStream oos;
		while (it.hasNext()) {
			Socket c = it.next().getSocket();
			try {
				oos = new ObjectOutputStream(c.getOutputStream());
				oos.writeObject(message);// 写入对象信息
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 向选中的用户发送数据
	private void sendMessage(Message message) {
		// 首先取得所有的values
		Set<String> cbs = onlines.keySet();
		Iterator<String> it = cbs.iterator();
		// 选中客户
		HashSet<String> clients = message.getClients();
		while (it.hasNext()) {
			// 在线客户
			String client = it.next();
			// 选中的客户中若是在线的，就发送message
			if (clients.contains(client)) {
				Socket c = onlines.get(client).getSocket();
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(c.getOutputStream());
					oos.writeObject(message);
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
