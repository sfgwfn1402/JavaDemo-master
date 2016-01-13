package com.andieguo.outOf;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * @Described£º¶ÑÒç³ö²âÊÔ
 * 
 * @VM args:-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
 * 
 * @author duwei
 * 
 * @FileNmae com.andieguo.outOf.HeapOutOfMemory
 */
public class HeapOutOfMemory {

	/**
	 * @param args
	 * 
	 * @Author duwei
	 */
	public static void main(String[] args) {
		List<TestCase> cases = new ArrayList<TestCase>();
		while (true) {
			cases.add(new TestCase());
		}
	}
}

/**
 * 
 * @Described£º²âÊÔÓÃÀý
 * 
 * @author duwei
 * 
 * @FileNmae com.andieguo.outOf.HeapOutOfMemory
 */

//class TestCase {
//	private String[] strs = new String[1024*1024];
//}
/*
 * [GC (Allocation Failure) --[PSYoungGen: 5605K->5605K(6144K)] 17893K->18250K(19968K), 0.0026210 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
[Full GC (Ergonomics) [PSYoungGen: 5605K->4515K(6144K)] [ParOldGen: 12644K->12602K(13824K)] 18250K->17117K(19968K), [Metaspace: 2855K->2855K(1056768K)], 0.0093570 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) --[PSYoungGen: 4515K->4515K(6144K)] 17117K->17133K(19968K), 0.0029530 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
[Full GC (Allocation Failure) [PSYoungGen: 4515K->4509K(6144K)] [ParOldGen: 12618K->12584K(13824K)] 17133K->17094K(19968K), [Metaspace: 2855K->2855K(1056768K)], 0.0086870 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at com.andieguo.outOf.TestCase.<init>(HeapOutOfMemory.java:51)
	at com.andieguo.outOf.HeapOutOfMemory.main(HeapOutOfMemory.java:33)
Heap
 PSYoungGen      total 6144K, used 4748K [0x00000007bf980000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 5632K, 84% used [0x00000007bf980000,0x00000007bfe230b0,0x00000007bff00000)
  from space 512K, 0% used [0x00000007bff80000,0x00000007bff80000,0x00000007c0000000)
  to   space 512K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007bff80000)
 ParOldGen       total 13824K, used 12584K [0x00000007bec00000, 0x00000007bf980000, 0x00000007bf980000)
  object space 13824K, 91% used [0x00000007bec00000,0x00000007bf84a2a8,0x00000007bf980000)
 Metaspace       used 2890K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 311K, capacity 386K, committed 512K, reserved 1048576K

 */