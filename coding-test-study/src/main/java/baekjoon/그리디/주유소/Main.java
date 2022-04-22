package baekjoon.그리디.주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()) - 1;

		// 거리 배열
		int[] arr1 = new int[N];

		// 기름 가격 배열 (마지막 도시는 주유할 필요가 없어서 생략)
		int[] arr2 = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());

		}

		long result = 0;
		long min = arr2[0];

		// 현재 위치가 비싸면 이전의 싼곳에서 주유를 한다
		for (int i = 0; i < N - 1; i++) {

			if (min > arr2[i]) {
				min = arr2[i];
			}
			result += arr1[i] * min;

		}
		System.out.println(result);

	}

}
