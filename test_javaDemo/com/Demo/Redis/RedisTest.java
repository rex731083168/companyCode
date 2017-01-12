package com.Demo.Redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
	private Jedis jedis;

	/**
	 * 测试用例启动前运行
	 */
	@Before
	public void setup() {
		// 服务器ip
		String ip = "127.0.0.1";
		// 服务器端口
		int port = 6379;
		// 授权密码
		String password = "123456";
		// 连接redis服务器
		jedis = new Jedis(ip, port);
		// 授权处理
		jedis.auth(password);
	}

	/**
	 * String测试
	 */
	@Test
	public void stringTest() {
		// 添加数据
		jedis.set("name", "Usher");

		System.out.println("添加数据:" + jedis.get("name") + "\n");
		// 拼接数据
		jedis.append("name", " is very cool!");

		System.out.println("拼接数据: " + jedis.get("name") + "\n");
		// 删除数据
		jedis.del("name");

		System.out.println("删除数据:" + jedis.get("name") + "\n");

		// 设置多个数据
		jedis.mset("name", "Usher", "age", "24", "sex", "male");

		// 年龄+10操作
		jedis.incrBy("age", 10);

		System.out.println("姓名:" + jedis.get("name") + "\040年龄:" + jedis.get("age") + "\040性别:" + jedis.get("sex") + "\n");
	}

	/**
	 * Map测试
	 */
	//@Test
	public void mapTest() {
		Map<String, String> map = new HashMap<String, String>();
		// 添加数据
		map.put("name", "Usher");
		map.put("age", "24");
		map.put("sex", "male");
		// 添加到redis中
		jedis.hmset("Information", map);

		System.out.println("添加Map数据:" + jedis.hmget("Information", "name", "age", "sex") + "\n");
		// 删除数据
		jedis.hdel("Information", "name");

		System.out.println("删除Map数据:" + jedis.hmget("Information", "name") + "\n");
		// 返回key=Information的值的个数
		System.out.println("返回key=Information的值的个数:" + jedis.hlen("Information") + "\n");
		// 判断是否存在key=Information的对象
		System.out.println("判断是否存在key=Information的对象:" + jedis.exists("Information") + "\n");
		// 返回map对象中的所有key值
		System.out.println("返回map对象中的所有key值:" + jedis.hkeys("Information") + "\n");
		// 返回map对象中的所有value值
		System.out.println("返回map对象中的所有value值:" + jedis.hvals("Information") + "\n");
		// 循环迭代key
		Iterator<String> it = jedis.hkeys("Information").iterator();
		// 判断是否有元素存在
		while (it.hasNext()) {
			// 获取元素key
			String key = it.next();
			System.out.println("返回key为" + key + "的值:" + jedis.hmget("Information", key) + "\n");
		}
	}

	/**
	 * List测试
	 */
	//@Test
	public void listTest() {
		// 先清空List
		jedis.del("Information");
		// 查看List是否清空
		System.out.println("Lis[清空后]t:" + jedis.lrange("Information", 0, -1) + "\n");
		// 添加数据
		jedis.lpush("Information", "Usher");
		jedis.lpush("Information", "sex");
		jedis.lpush("Information", "age");
		// 查看List元素
		System.out.println("List[添加后]:" + jedis.lrange("Information", 0, -1) + "\n");
		// 清空List
		jedis.del("Information");
		// 添加数据
		jedis.lpush("Information", "Elliot");
		jedis.lpush("Information", "sex");
		jedis.lpush("Information", "age");
		// 查看List元素
		System.out.println("List[清空+添加]:" + jedis.lrange("Information", 0, -1) + "\n");
	}

}
