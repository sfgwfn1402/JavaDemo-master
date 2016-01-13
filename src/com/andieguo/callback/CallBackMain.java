package com.andieguo.callback;

/**
 * Function: Ö÷Àà. <br/>
 * 
 * @author duwei
 */
public class CallBackMain {

	public static void main(String[] args) {
		new TestCallBack().compute(10, new IComputeCallBack() {

			@Override
			public void onComputeEnd() {

				System.out.println("end back!!!");

			}
		});
	}
}

class TestCallBack {
	public void compute(int n, IComputeCallBack callback) {
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}
		callback.onComputeEnd();
	}
}