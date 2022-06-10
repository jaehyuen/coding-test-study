package baekjoon.브루트포스.십자카드_문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static Set<Integer> set = new HashSet<Integer>();
	static int[] arr = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		find(0, 1);

		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 주어진 값의 시계수를 찾는다
		int min = findMin();
		set.add(min);

		ArrayList<Integer> list = new ArrayList<>(set);
		// 정렬
		Collections.sort(list);

		// 주어진 시계수 인덱스 + 1 값을 리턴
		System.out.println(list.indexOf(min) + 1);
	}

	public static void find(int idx, int start) {

		// 카드가 완성되면 시계수를 찾는다
		if (idx == 4) {
			set.add(findMin());
			return;

		}

		for (int i = start; i < 10; i++) {
			arr[idx] = i;
			find(idx + 1, start);
		}
	}

	public static int findMin() {
		// 4개의 수중 최소값을 찾아 리턴

		int min = Math.min((arr[0] * 1000) + (arr[1] * 100) + (arr[2] * 10) + arr[3], 9999);
		min = Math.min((arr[1] * 1000) + (arr[2] * 100) + (arr[3] * 10) + arr[0], min);
		min = Math.min((arr[2] * 1000) + (arr[3] * 100) + (arr[0] * 10) + arr[1], min);
		min = Math.min((arr[3] * 1000) + (arr[0] * 100) + (arr[1] * 10) + arr[2], min);
		return min;

	}

}