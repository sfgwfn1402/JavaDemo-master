package com.andieguo.aop.cglib;

import java.lang.reflect.Method;

import com.andieguo.aop.model.Business;
import com.andieguo.aop.model.IBusiness2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 字节码生成机制演示AOP<br>
 * 使用Cglib来实现动态字节码技术。Cglib是一个强大的,高性能的Code生成类库，它可以在运行期间扩展Java类和实现Java接口，它封装了Asm，
 * 所以使用Cglib前需要引入Asm的jar
 * 
 * @author duwei
 */
public class CglibAopDemo {

	public static void main(String[] args) {
		byteCodeGe();
	}

	public static void byteCodeGe() {
		// 创建一个织入器
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(Business.class);
		// 设置需要织入的逻辑
		enhancer.setCallback(new LogIntercept());
		// 创建子类
		IBusiness2 newBusiness = (IBusiness2) enhancer.create();
		newBusiness.doSomeThing2();
	}

	/**
	 * 记录日志
	 */
	public static class LogIntercept implements MethodInterceptor {

		@Override
		public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			// 执行原有逻辑
			Object rev = proxy.invokeSuper(target, args);
			// 执行织入的日志
			if (method.getName().equals("doSomeThing2")) {
				System.out.println("记录日志");
			}
			return rev;
		}
	}
}
