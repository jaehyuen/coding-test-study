package baekjoon.그리디.게임을_만든_동준이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		// 배열에 값 저장
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int result = 0;
		// 맨 뒤부터 감소키킨다
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] >= arr[i + 1]) {
				int tmp = arr[i] - arr[i + 1] + 1;
				arr[i] -= tmp;
				result += tmp;
			}
		}
		System.out.println(result);
	}

}
