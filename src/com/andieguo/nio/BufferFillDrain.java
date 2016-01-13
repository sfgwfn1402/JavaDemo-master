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

	// ������
	public static void main(String[] argv) throws Exception {
		CharBuffer buffer = CharBuffer.allocate(100);
		while (fillBuffer(buffer)) {
			buffer.flip();// ׼����������(��ת�˻��������������õ���ǰλ�ã���ǰλ������Ϊ0��������������Ǳ�����)
			drainBuffer(buffer);
			buffer.clear();// ��ջ�����
		}
	}

	/**
	 * ���������
	 */
	private static void drainBuffer(CharBuffer buffer) {
		while (buffer.hasRemaining()) {// �ڻ�������ǰλ��������֮����Ԫ��
			System.out.print(buffer.get());
		}
		System.out.println("");
	}

	/**
	 * ��仺����
	 */
	private static boolean fillBuffer(CharBuffer buffer) {
		if (index >= strings.length) {
			return false;
		}
		System.out.println("���...");
		String string = strings[index++];
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			buffer.put(c);
			System.out.println(c);
		}
		return true;
	}
}
