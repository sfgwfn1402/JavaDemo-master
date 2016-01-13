package com.andieguo.assist;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Demo01 {

	// ��ȡ��ļ���Ϣ
	public static void test01() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.andieguo.assist.User");

		// �õ��ֽ���
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));

		System.out.println(cc.getName());// ��ȡ����
		System.out.println(cc.getSimpleName());// ��ȡ��Ҫ����
		System.out.println(cc.getSuperclass());// ��ȡ����
		System.out.println(cc.getInterfaces());// ��ȡ�ӿ�
		System.out.println(cc.getMethods());// ��ȡ
	}

	// ������һ������
	public static void test02() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.andieguo.assist.User");

		// ��һ��
		// CtMethod cm = CtMethod.make("public String getName(){return name;}",
		// cc);
		// �ڶ���
		// ����������ֵ���ͣ�������������������
		CtMethod cm = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType }, cc);
		cm.setModifiers(Modifier.PUBLIC);// ���ʷ�Χ
		cm.setBody("{return $1+$2;}");

		// cc.removeMethod(m) ɾ��һ������
		cc.addMethod(cm);
		// ͨ��������÷���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();// ͨ�������޲ι������������µĶ���

		Method m = clazz.getDeclaredMethod("add", int.class, int.class);
		Object result = m.invoke(obj, 2, 3);
		System.out.println(result);
	}

	// �޸����еķ���
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.andieguo.assist.User");

		CtMethod cm = cc.getDeclaredMethod("hello", new CtClass[] { pool.get("java.lang.String") });
		cm.insertBefore("System.out.println(\"����ǰ\");");// ����ǰ
		cm.insertAt(29, "System.out.println(\"29\");");// �к�
		cm.insertAfter("System.out.println(\"���ú�\");");// ���ú�

		// ͨ��������÷���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();
		Method m = clazz.getDeclaredMethod("hello", String.class);
		Object result = m.invoke(obj, "����");
		System.out.println(result);
	}

	// �޸���������
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.andieguo.assist.User");

		// ����
		CtField cf = new CtField(CtClass.intType, "age", cc);
		cf.setModifiers(Modifier.PRIVATE);
		cc.addField(cf);
		// ������Ӧ��get set����
		cc.addMethod(CtNewMethod.getter("getAge", cf));
		cc.addMethod(CtNewMethod.setter("setAge", cf));

		// ��������

		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();
		Field field = clazz.getDeclaredField("age");
		System.out.println(field);
 		Method m = clazz.getDeclaredMethod("setAge", int.class);
		m.invoke(obj, 16);
		Method m2 = clazz.getDeclaredMethod("getAge", null);
		Object resutl = m2.invoke(obj, null);
		System.out.println(resutl);
	}

	// �������췽��
	public static void test05() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.andieguo.assist.User");

		CtConstructor[] cons = cc.getConstructors();
		for (CtConstructor con : cons) {
			System.out.println(con);
		}
	}

	public static void main(String[] args) throws Exception {
		// test01();
		// test02();
//		test03();
		 test04();
		// test05();
	}

}