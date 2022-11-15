package baekjoon.그리디.라디오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// 기본 버튼으로 가능한 갯수 구하기
		int min = Math.abs(A - B);

		int N = Integer.parseInt(br.readLine());

		// 즐겨찾기 버튼으로 가능한 갯수 구하기
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			min = Math.min(min, Math.abs(tmp - B) + 1);

		}

		System.out.println(min);
	}

}
