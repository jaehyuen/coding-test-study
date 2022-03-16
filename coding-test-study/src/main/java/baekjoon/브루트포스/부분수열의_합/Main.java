package baekjoon.브루트포스.부분수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	// 부분 수열의 개수 카운팅 변수
	static int cnt = 0;

	// 입력값 변수
	static int N;
	static int S;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 부분수열 값을 찾는 함수
		find(0, 0, 0);

		System.out.println(cnt);

	}

	public static void find(int sum, int start, int idx) {

		// 찾는값이 0일때 처음값을 뺴주기위함
		if (start != 0 && sum == S) {
			cnt++;
		}
		if (idx == N) {
			return;
		}

		// 조합 공식으로 모든 조합을 찾아본다
		for (int i = start; i < N; i++) {
			find(sum + arr[i], i + 1, idx + 1);
		}

	}
}
