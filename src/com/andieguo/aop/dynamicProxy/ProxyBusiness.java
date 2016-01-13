package com.andieguo.aop.dynamicProxy;

import java.lang.reflect.Method;

import com.andieguo.aop.dynamicProxy.DynamicProxyDemo.LogInvocationHandler;
import com.andieguo.aop.model.Business;
import com.andieguo.aop.model.IBusiness;
import com.andieguo.aop.model.IBusiness2;

/**
 * ֯�������ɵĴ�����
 * 
 * @author tengfei.fangtf
 */
public class ProxyBusiness implements IBusiness, IBusiness2 {

	private LogInvocationHandler h;

	@Override
	public void doSomeThing2() {
		try {
			Method m = (h.target).getClass().getMethod("doSomeThing", null);
			h.invoke(this, m, null);
		} catch (Throwable e) {
			// �쳣���� 1���ԣ�
		}
	}

	@Override
	public boolean doSomeThing() {
		try {
			Method m = (h.target).getClass().getMethod("doSomeThing2", null);
			return (Boolean) h.invoke(this, m, null);
		} catch (Throwable e) {
			// �쳣���� 1���ԣ�
		}
		return false;
	}

	public ProxyBusiness(LogInvocationHandler h) {
		this.h = h;
	}

	// ������
	public static void main(String[] args) {
		// ����AOP��Advice
		staticDynamic();
	}

	public static void staticDynamic() {
		LogInvocationHandler handler = new LogInvocationHandler(new Business());
		new ProxyBusiness(handler).doSomeThing();
		new ProxyBusiness(handler).doSomeThing2();
	}

}
