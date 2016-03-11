package com.andieguo.aop.javassist;

import com.andieguo.aop.model.Business;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Translator;

/**
 * ʹ��Javassist��ʾAop��Demo.<br>
 * ʹ��ϵͳ����������������Զ����������������������������һ������ؼ�����������������Ŀ���౻����ʱ��֯�������߼�
 * 
 * @author duwei
 */
public class JavassistAopDemo {

	public static void main(String[] args) throws Exception {
		aop();
	}

	public static void aop() throws NotFoundException, CannotCompileException,
			InstantiationException, IllegalAccessException {
		// ��ȡ���CtClass������ClassPool
		ClassPool cp = ClassPool.getDefault();
		// ����һ���������
		Loader cl = new Loader();
		// ����һ��ת������������ص�ʱ��
		cl.addTranslator(cp, new MyTranslator());
		// ����װ�ص�JVM
		try {
			cl.run("com.andieguo.aop.javassist.JavassistAopDemo$MyTranslator",
					null);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		CtClass cc = cp.get("com.andieguo.aop.model.Business");
		// ���ָ���������ķ���
		CtMethod m = cc.getDeclaredMethod("doSomeThing");
		// �ڷ���ִ��ǰ�������
		m.insertBefore("{ System.out.println(\"��¼��־\"); }");
		((Business) cc.toClass().newInstance()).doSomeThing();

	}

	public static class MyTranslator implements Translator {

		public void start(ClassPool pool) throws NotFoundException,
				CannotCompileException {
		}

		/**
		 * ��װ�ص�JVMǰ���д���֯��
		 */
		public void onLoad(ClassPool pool, String classname) {
			if (!"com.andieguo.aop.model.Business".equals(classname)) {
				return;
			}
			// ͨ��������ȡ���ļ�
			try {
				CtClass cc = pool.get(classname);
				// ���ָ���������ķ���
				CtMethod m = cc.getDeclaredMethod("doSomeThing");
				// �ڷ���ִ��ǰ�������
				m.insertBefore("{ System.out.println(\"��¼��־\"); }");
			} catch (NotFoundException e) {
			} catch (CannotCompileException e) {
			}
		}

		public static void main(String[] args) {
			Business b = new Business();
			b.doSomeThing2();
			b.doSomeThing();
		}
	}

}
