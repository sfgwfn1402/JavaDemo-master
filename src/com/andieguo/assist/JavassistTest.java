package com.andieguo.assist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

public class JavassistTest {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("com.andieguo.assist.User");

		// ��������
		CtField field01 = CtField.make("private int id;", cc);
		CtField field02 = CtField.make("private String name;", cc);
		cc.addField(field01);
		cc.addField(field02);

		// ��������
		CtMethod method01 = CtMethod.make("public String getName(){return name;}", cc);
		CtMethod method02 = CtMethod.make("public void setName(String name){this.name = name;}", cc);
		cc.addMethod(method01);
		cc.addMethod(method02);

		// ����вι�����
		CtConstructor constructor = new CtConstructor(new CtClass[] { CtClass.intType, pool.get("java.lang.String") },
				cc);
		constructor.setBody("{this.id=id;this.name=name;}");
		cc.addConstructor(constructor);
		// �޲ι�����
		CtConstructor cons = new CtConstructor(null, cc);
		cons.setBody("{}");
		cc.addConstructor(cons);

		cc.writeFile("/Users/duwei/Documents/workspace/JavaDemo-master/src");
	}

}