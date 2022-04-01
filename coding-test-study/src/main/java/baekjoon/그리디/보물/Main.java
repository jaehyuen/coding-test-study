package baekjoon.그리디.보물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		// 배열 두개 생성
		int[] arr1 = new int[N];
		Integer[] arr2 = new Integer[N];

		for (int i = 0; i < N; i++) {

			arr1[i] = Integer.parseInt(st1.nextToken());
			arr2[i] = Integer.parseInt(st2.nextToken());

		}

		// 두개를 오름,내림 차순으로 정렬후 연산
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());

		int result = 0;
		for (int i = 0; i < N; i++) {
			result += arr1[i] * arr2[i];
		}
		System.out.println(result);
	}

}
