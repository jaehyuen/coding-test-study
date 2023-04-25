package baekjoon.그래프.숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int[] numArr;
	public static int[] arr;
	public static boolean[] v;

	public static ArrayList<Integer> list = new ArrayList<>();

	public static HashSet<Integer> result = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());

		}

		for (int i = 0; i < N; i++) {

			// 방문 체크 배열
			v = new boolean[N];
			v[i] = true;
			find(numArr[i] - 1, i);

		}

		// 결과 정렬용 리스트
		ArrayList<Integer> sort = new ArrayList<>(result);

		// 정렬
		Collections.sort(sort);

		StringBuilder sb = new StringBuilder();

		sb.append(sort.size() + "\n");

		for (int i : sort) {
			sb.append((i + 1) + "\n");
		}

		System.out.print(sb.toString());

	}

	public static boolean find(int now, int parent) {

		// 방문 체크
		if (v[now]) {

			// 시작 지점에 다시 돌아오면 결과에 쭉 넣어줌
			if (now == parent) {
				result.add(now);

				return true;
			}

			// 시작지점으로 돌아온게 아니면 결과에 안넣음
			return false;
		}
		v[now] = true;

		if (find(numArr[now] - 1, parent)) {

			// 사이클인게 파익됫으니 결과에 넣음
			result.add(now);
			return true;
		} else {
			return false;
		}

	}

}
