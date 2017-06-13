package javaInCompany;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 单例模式
 * @author admin
 *
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
    	SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        {
        	s2 = null;	
        }
        try {
			Class<SingletonClass> clazz = SingletonClass.class;
			Constructor<SingletonClass> cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);
			s2 = cons.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
        System.out.println("Instance 1 hash:"+s1.hashCode());
        System.out.println("Instance 2 hash:"+s2.hashCode());
	}
}

class SingletonClass implements Serializable{
	private static volatile SingletonClass singletonClass;
	private SingletonClass(){
		if(singletonClass!=null){
			throw new RuntimeException("Use getInstance() method to get the single instance of this class");
		}
	}
	public static SingletonClass getInstance(){
		if(singletonClass==null){
			synchronized (SingletonClass.class) {
				if(singletonClass==null){
					singletonClass = new SingletonClass();
				}
			}
		}
		return singletonClass;
	}
	protected SingletonClass readResolve(){
		return getInstance();
	}
}
