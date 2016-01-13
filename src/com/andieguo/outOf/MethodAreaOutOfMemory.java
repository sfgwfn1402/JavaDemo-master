package com.andieguo.outOf;

import java.lang.reflect.Method;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;

/**
 * @Described：方法区溢出测试使用技术 CBlib <br>
 * 
 * @VM args : -XX:PermSize=10M // -XX:MaxPermSize=10M <br>
 * @author duwei <br>
 * @FileNmae com.andieguo.outOf.MethodAreaOutOfMemory
 */
public class MethodAreaOutOfMemory {
	/** * @param args * @Author YHJ create at 2011-11-12 下午08:47:51 */
	public static void main(String[] args) {
//		while (true) {
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(TestCase.class);
//			enhancer.setUseCache(false);
//			enhancer.setCallback(new MethodInterceptor() {
//				@Override
//				public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
//					return arg3.invokeSuper(arg0, arg2);
//				}
//			});
//			enhancer.create();
//		}
	}
}

/**
 * * @Described：测试用例 * @author YHJ create at 2011-11-12 下午08:53:09 * @FileNmae
 * com.yhj.jvm.memory.methodArea.MethodAreaOutOfMemory.java
 */
class TestCase {
}