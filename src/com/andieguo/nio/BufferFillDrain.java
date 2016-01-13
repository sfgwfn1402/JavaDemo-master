package com.andieguo.nio;

import java.nio.CharBuffer;

/**
 * Buffer fill/drain example. This code uses the simplest * means of filling and
 * draining a buffer: one element at * a time.
 * 
 * @author duwei
 */
public class BufferFillDrain {
	private static int index = 0;
	private static String[] strings = { "A random string value", "The product of an infinite number of monkeys",
			"Hey hey we're the Monkees", "Opening act for the Monkees: Jimi Hendrix",
			"'Scuse me while I kiss this fly", // Sorry Jimi ;-)
												// "Help Me! Help Me!",
	};

	// 主方法
	public static void main(String[] argv) throws Exception {
		CharBuffer buffer = CharBuffer.allocate(100);
		while (fillBuffer(buffer)) {
			buffer.flip();// 准备读出数据(翻转此缓冲区，上限设置到当前位置，当前位置设置为0，如果定义标记则标记被丢弃)
			drainBuffer(buffer);
			buffer.clear();// 清空缓冲区
		}
	}

	/**
	 * 输出缓存区
	 */
	private static void drainBuffer(CharBuffer buffer) {
		while (buffer.hasRemaining()) {// 在缓冲区当前位置与上限之间有元素
			System.out.print(buffer.get());
		}
		System.out.println("");
	}

	/**
	 * 填充缓冲区
	 */
	private static boolean fillBuffer(CharBuffer buffer) {
		if (index >= strings.length) {
			return false;
		}
		System.out.println("填充...");
		String string = strings[index++];
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			buffer.put(c);
			System.out.println(c);
		}
		return true;
	}
}
