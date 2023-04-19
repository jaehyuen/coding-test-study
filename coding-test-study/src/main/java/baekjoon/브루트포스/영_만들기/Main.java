package baekjoon.브루트포스.영_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			N = Integer.parseInt(br.readLine());

			// 문자열 제작 시작
			find(0, "1");
			System.out.println();

		}

	}

	public static int sum(String str) {
		char[] arr = str.toCharArray();
		int idx = 0;
		int operator = 1;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			// 연살자가 왓으면 이전 연산을 진행
			if (arr[i] == '+') {
				int num = 0;
				for (int j = idx; j < i; j++) {
					num *= 10;
					num -= '0' - arr[j];
				}

				sum += num * operator;
				operator = 1;
				idx = -1;
			} else if (arr[i] == '-') {

				int num = 0;
				for (int j = idx; j < i; j++) {
					num *= 10;
					num -= '0' - arr[j];
				}
				sum += num * operator;

				operator = -1;
				idx = -1;
			} else if (idx == -1) {
				// 숫자 시작 인덱스 지정
				idx = i;
			}
		}
		int num = 0;
		for (int j = idx; j < arr.length; j++) {
			num *= 10;
			num -= '0' - arr[j];
		}

		sum += num * operator;
		return sum;

	}

	public static void find(int idx, String str) {
		if (idx == N - 1) {

			// 식을 다 만들엇으면 계산
			if (sum(str.replaceAll(" ", "")) == 0) {

				// 0이면 출력
				System.out.println(str);
			}

			return;
		}

		// 공백, 더하기, 빼기 순으로 문자열 생성
		find(idx + 1, str + " " + (idx + 2));
		find(idx + 1, str + "+" + (idx + 2));
		find(idx + 1, str + "-" + (idx + 2));

	}

}