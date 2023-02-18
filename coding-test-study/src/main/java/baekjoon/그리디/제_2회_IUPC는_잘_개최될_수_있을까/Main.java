package baekjoon.그리디.제_2회_IUPC는_잘_개최될_수_있을까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 펜 갯수 정렬
		Arrays.sort(arr);

		// 빌린 회원 수
		int i = 1;

		// 총 빌린 펜 갯수
		int sum = 0;

		// 펜을 다 빌리거나 펜이 부족하기 전까진 반복
		while (M * K > sum && i <= N) {
			sum += arr[N - i];
			i++;
		}

		if (M * K > sum) {
			// 펜이 부족할떄
			System.out.println("STRESS");
		} else {
			System.out.println(i - 1);
		}
	}
}
