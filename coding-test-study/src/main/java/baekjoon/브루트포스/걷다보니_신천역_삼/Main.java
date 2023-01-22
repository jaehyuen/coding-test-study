package baekjoon.브루트포스.걷다보니_신천역_삼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int N;
	public static HashSet<Integer> set = new HashSet<>();
	public static int value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		// 기준값 설정
		value = (int) Math.pow(10, N - 1);
		find(0);

		System.out.println(set.size());

	}

	public static void find(int idx) {

		// 자릿수를 다 구했을떄
		if (idx == N) {

			// 숫자로 변경
			String tmp = "";
			for (int i : arr) {
				tmp += i;
			}
			int num = Integer.parseInt(tmp);

			// 3의 배수면서 기준값보다 크면 저장
			if (num % 3 == 0 && value <= num) {
				set.add(num);
			}

			return;
		}
		for (int i = 0; i < 3; i++) {
			arr[idx] = i;
			find(idx + 1);
		}
	}
}