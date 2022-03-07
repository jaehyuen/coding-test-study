package baekjoon.브루트포스.최대_페이지_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 페이지,시간 저장 배열
	static int arr1[];
	static int arr2[];

	// 챕터 수, 날짜
	static int N;
	static int M;

	// 결과
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 챕터 수, 날짜 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 페이지,시간 저장 배열
		arr1 = new int[M];
		arr2 = new int[M];

		// 페이지,시간 저장 배열
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			arr1[i] = Integer.parseInt(st.nextToken());
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		// 검색 함수
		find(0, 0, 0);
		System.out.println(result);
	}

	public static void find(int start, int sum, int days) {

		// 최대 일수가 지나면 리턴
		if (days > N) {
			return;
		}

		// 최대값 갱신
		result = Math.max(result, sum);

		// 중복 되지않게 조합
		for (int i = start; i < M; i++) {
			find(i + 1, sum + arr2[i], days + arr1[i]);
		}

	}
}