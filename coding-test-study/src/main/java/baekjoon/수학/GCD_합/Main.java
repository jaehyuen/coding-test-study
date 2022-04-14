package baekjoon.수학.GCD_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 개수 입력
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 숫자 갯수 입력
			int N = Integer.parseInt(st.nextToken());
			int sum = 0;

			// 숫자 저장
			int[] arr = new int[N];

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());

			}

			// 숫자 정렬
			Arrays.sort(arr);

			// 큰수부터 2개씩 최대공약수를 구해준다
			for (int j = N - 1; j >= 1; j--) {
				for (int k = j - 1; k >= 0; k--) {

					sum += find(arr[j], arr[k]);
				}
			}
			System.out.println(sum);

		}

	}

	public static int find(int a, int b) {

		int tmp = a % b;
		if (tmp == 0) {
			return b;
		}
		return find(b, tmp);

	}
}
