package com.andieguo.outOf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @Described：直接内存溢出测试 <br>
 * 
 * @VM args: -Xmx20M -XX:MaxDirectMemorySize=10M <br>
 * @author duwei
 * @FileNmae com.andieguo.outOf.DirectoryMemoryOutOfmemory
 */
public class DirectoryMemoryOutOfmemory {
	private static final int ONE_MB = 1024 * 1024;
	private static int count = 1;

	/** * @param args * @Author YHJ create at 2011-11-12 下午09:05:54 */
	public static void main(String[] args) {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			Unsafe unsafe = (Unsafe) field.get(null);
			while (true) {
				unsafe.allocateMemory(ONE_MB);
				count++;
			}
		} catch (Exception e) {
			System.out.println("Exception:instance created " + count);
			e.printStackTrace();
		} catch (Error e) {
			System.out.println("Error:instance created " + count);
			e.printStackTrace();
		}
	}
}