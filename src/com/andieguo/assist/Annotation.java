/**  
 * Project Name:JavaDemo-master  
 * File Name:Annotation.java  
 * Package Name:com.andieguo.assist  
 * Date:2016年1月13日上午11:54:03  
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.  
 */

package com.andieguo.assist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * 注解操作
 */
public class Annotation {
	public static void main(String[] args) throws NotFoundException, ClassNotFoundException {
		CtClass cc = ClassPool.getDefault().get("com.andieguo.assist.Point");
		Object[] all = cc.getAnnotations();
		Author a = (Author) all[0];
		String name = a.name();
		int year = a.year();
		System.out.println(name + ":" + year);
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
	String name();
	int year();
}

@Author(name = "over", year = 2012)
class Point {
	int x;
	int y;
}