package com.andieguo.aop.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.andieguo.aop.model.Business;
import com.andieguo.aop.model.IBusiness;
import com.andieguo.aop.model.IBusiness2;

/**
 * 使用动态代理实现AOP的Demo演示<br>
 * 动态代理其实就是代理对象的生成。
 * 优点：有一定的灵活性
 * 缺点：必须实现一个接口，使用反射生成类文件，可能引起Full GC
 * 
 * @author duwei
 */
public class DynamicProxyDemo {

	public static void main(String[] args) {
		aop();
	}

	public static void aop() {
		// 需要代理的接口，被代理类实现的多个接口都必须在这里定义
		Class[] proxyInterface = new Class[] { IBusiness.class, IBusiness2.class };
		// 构建AOP的Advice
		LogInvocationHandler handler = new LogInvocationHandler(new Business());
		// 生成代理类的类加载器
		ClassLoader classLoader = DynamicProxyDemo.class.getClassLoader();
		// 生成代理类
		IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
		// 使用代理类的实例来调用方法。
		proxyBusiness.doSomeThing2();
		((IBusiness) proxyBusiness).doSomeThing();
	}

	/**
	 * 打印日志的切面
	 */
	public static class LogInvocationHandler implements InvocationHandler {

		public Object target; // 目标对象

		LogInvocationHandler(Object target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// 执行原有逻辑
			Object rev = method.invoke(target, args);
			// 执行织入的日志
			if (method.getName().equals("doSomeThing")) {
				System.out.println("动态代理记录日志");
			}
			return rev;
		}
	}

}
