package baekjoon.수학.다리_놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			BigInteger i1 = new BigInteger("1");
			BigInteger i2 = new BigInteger("1");
			
			//조합 공식 진행
			for (int j = 0; j < N; j++) {
				i1 = i1.multiply(new BigInteger(String.valueOf(M - j)));
				i2 = i2.multiply(new BigInteger(String.valueOf(j + 1)));
			}
			System.out.println(i1.divide(i2));
		}

	}

}
