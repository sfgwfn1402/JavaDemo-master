package com.andieguo.aop.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.andieguo.aop.model.Business;
import com.andieguo.aop.model.IBusiness;
import com.andieguo.aop.model.IBusiness2;

/**
 * ʹ�ö�̬����ʵ��AOP��Demo��ʾ<br>
 * ��̬������ʵ���Ǵ����������ɡ�
 * �ŵ㣺��һ���������
 * ȱ�㣺����ʵ��һ���ӿڣ�ʹ�÷����������ļ�����������Full GC
 * 
 * @author duwei
 */
public class DynamicProxyDemo {

	public static void main(String[] args) {
		aop();
	}

	public static void aop() {
		// ��Ҫ����Ľӿڣ���������ʵ�ֵĶ���ӿڶ����������ﶨ��
		Class[] proxyInterface = new Class[] { IBusiness.class, IBusiness2.class };
		// ����AOP��Advice
		LogInvocationHandler handler = new LogInvocationHandler(new Business());
		// ���ɴ�������������
		ClassLoader classLoader = DynamicProxyDemo.class.getClassLoader();
		// ���ɴ�����
		IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
		// ʹ�ô������ʵ�������÷�����
		proxyBusiness.doSomeThing2();
		((IBusiness) proxyBusiness).doSomeThing();
	}

	/**
	 * ��ӡ��־������
	 */
	public static class LogInvocationHandler implements InvocationHandler {

		public Object target; // Ŀ�����

		LogInvocationHandler(Object target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// ִ��ԭ���߼�
			Object rev = method.invoke(target, args);
			// ִ��֯�����־
			if (method.getName().equals("doSomeThing")) {
				System.out.println("��̬�����¼��־");
			}
			return rev;
		}
	}

}
