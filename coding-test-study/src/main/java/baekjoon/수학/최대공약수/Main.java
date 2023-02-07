package baekjoon.수학.최대공약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		long            A   = Long.parseLong(st.nextToken());
		long            B   = Long.parseLong(st.nextToken());

		// 유클리드 호제법 실행
		long            cnt = find(Math.max(A, B), Math.min(A, B));

		StringBuilder   sb  = new StringBuilder();

		// 최대공약수만큼 1을 붙여줌
		for (int i = 0; i < cnt; i++) {
			sb.append(1);
		}
		System.out.println(sb.toString());

	}

	public static long find(long a, long b) {
		if (b == 0) {
			return a;
		}
		return find(b, a % b);
	}

}
