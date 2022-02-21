package baekjoon.수학.로마_숫자_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr1;
	static int[] arr2;
	public static boolean[] v = new boolean[1001];

	static int cnt = 0;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		//로마 숫자 배열 생성
		arr1 = new int[] { 1, 5, 10, 50 };
		arr2 = new int[N];

		
		//조합 찾기 함수 실행
		find(0, 0, 0);

		System.out.println(cnt);
	}

	public static void find(int r, int start, int sum) {
		if (r == N) {
			//합계가 같은 숫자는 같은것으로 취급
			if (!v[sum]) {
				v[sum] = true;
				cnt++;
			}

		} else {
			//조합 하기
			for (int i = start; i < 4; i++) {
				arr2[r] = arr1[i];
				find(r + 1, i, sum + arr1[i]);

			}
		}
	}

}
