package baekjoon.수학.링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 링의 개수
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = -1;
		int b = -1;
		for (int i = 0; i < N; i++) {
			// 첫번째 링은 무시한다
			if (i == 0) {
				a = Integer.parseInt(st.nextToken());
			} else {

				// 두번째 링부터 최대공약수를 구하여 회전수를 구한
				b = Integer.parseInt(st.nextToken());
				int spinTmp = find(a, b);
				System.out.println(a / spinTmp + "/" + b / spinTmp);
			}

		}

	}

	public static int find(int a, int b) {
		int tmp = a % b;
		if (tmp == 0)
			return b;

		return find(b, tmp);
	}
}
