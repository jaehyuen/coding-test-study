package baekjoon.브루트포스.부분수열의_합_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int[]            arr;
	public static int              N;
	public static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N   = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 부분 수열 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 경우의수 다 구하기
		find(0, 0, 0);

		int idx = 1;

		// 못만든값중 가장 작은값 구하기
		while (true) {
			if (!set.contains(idx)) {
				System.out.println(idx);
				return;
			}
			idx++;
		}

	}

	public static void find(int start, int sum, int idx) {
		// 조합된 값 추가
		set.add(sum);
		if (idx == N) {
			return;
		}

		for (int i = start; i < N; i++) {
			find(i + 1, sum + arr[i], idx + 1);
		}
	}
}