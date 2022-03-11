package baekjoon.수학.베르트랑_공준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 에라토스테네스의 체 공식을 위한 배열
		boolean[] v = new boolean[123456 * 2 + 1];

		// 소수여부를 구해줌 123456*2
		for (int i = 2; i * i <= 123456 * 2; i++) {
			if (!v[i]) {
				for (int j = i * i; j <= 123456 * 2; j += i) {
					v[j] = true;
				}
			}
		}
		while (true) {
			int N = Integer.parseInt(br.readLine());

			// 0이 나오면 종료
			if (N == 0) {
				break;
			}

			int cnt = 0;
			
			//N ~ 2N 까지 소수 카운팅
			for (int i = N + 1; i <= N * 2; i++) {
				if (!v[i])
					cnt++;
			}

			System.out.println(cnt);

		}
	}

}
