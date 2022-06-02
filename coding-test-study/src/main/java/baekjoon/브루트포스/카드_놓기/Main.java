package baekjoon.브루트포스.카드_놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	static int n;
	static int k;

	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		arr1 = new int[n];
		arr2 = new int[k];
		v = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(br.readLine());
		}

		find(0);
		System.out.println(set.size());

	}

	public static void find(int idx) {

		if (k == idx) {
			// 조함된 값을 스트링으로 이어붙이고 정수로 변환
			String str = "";
			for (int i : arr2) {
				str += i;
			}

			set.add(Integer.parseInt(str));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				arr2[idx] = arr1[i];
				find(idx + 1);
				v[i] = false;
			}
		}

	}
}