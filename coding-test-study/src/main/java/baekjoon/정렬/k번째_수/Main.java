package baekjoon.정렬.k번째_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열의 갯수, K 입력
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		System.out.println(list.get(K - 1));

//		int[] arr = new int[N];
//
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		// 선택 정렬로 정렬한다 (K번째까지만 정렬하면 됨)
//		for (int i = 0; i < K; i++) {
//
//			int idx = Integer.MAX_VALUE;
//			int min = Integer.MAX_VALUE;
//
//			// 최솟값을 찾아준다
//			for (int j = i; j < N; j++) {
//
//				if (min > arr[j]) {
//					min = arr[j];
//					idx = j;
//				}
//
//			}
//
//			// 앞자리부터 최솟갑으로 변경해준다
//			int tmp = arr[i];
//			arr[i] = arr[idx];
//			arr[idx] = tmp;
//
//		}
//
//		System.out.println(arr[K - 1]);
	}

}
