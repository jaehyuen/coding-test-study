package baekjoon.그리디.햄버거_분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] str = br.readLine().toCharArray();

		int result = 0;

		for (int i = 0; i < N; i++) {

			int tmp1 = K - i > 0 ? 0 : i - K;
			int tmp2 = K + i >= N ? N - 1 : K + i;

			if (str[i] == 'P') {
				for (int j = tmp1; j <= tmp2; j++) {
					if (str[j] == 'H') {
						str[j] = 0;
						str[i] = 0;
						result++;
						break;
					}

				}
			}

		}
		System.out.println(result);

	}

}
