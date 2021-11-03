package baekjoon.수학.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static long  cnt = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st   = new StringTokenizer(br.readLine());
		int             n    = Integer.parseInt(st.nextToken());
		int             m    = Integer.parseInt(st.nextToken());

		BigInteger      int1 = BigInteger.ONE;
		BigInteger      int2 = BigInteger.ONE;
		for (int i = 0; i < m; i++) {
			int1 = int1.multiply(new BigInteger(String.valueOf(n - i)));
			int2 = int2.multiply(new BigInteger(String.valueOf(i + 1)));
		}
		System.out.println(int1.divide(int2));

//		arr = new int[n];
//		int[]     arr2 = new int[m];
//		boolean[] v    = new boolean[n];
//
//		for (int i = 1; i <= n; i++) {
//			arr[i - 1] = i;
//		}
//		test(arr2, v, 0, 0, m);
//		System.out.println(cnt);

	}

//	public static void test(int[] arr2, boolean[] v, int start, int length, int m) {
//
//		if (length == m) {
//			cnt++;
//			return;
//		}
//		for (int i = start; i < arr.length; i++) {
//			if (!v[i]) {
//				v[i]         = true;
//				arr2[length] = arr[i];
//				test(arr2, v, i + 1, length + 1, m);
//				v[i] = false;
//			}
//		}
//
//	}

}
