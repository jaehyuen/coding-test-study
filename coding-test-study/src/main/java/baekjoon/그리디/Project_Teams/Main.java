package baekjoon.그리디.Project_Teams;

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
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N * 2; i++) {

			list.add(Integer.parseInt(st.nextToken()));

		}

		// 코딩 실력 정렬
		Collections.sort(list);

		int min = Integer.MAX_VALUE;
		int j = N * 2 - 1;

		// 최대 최소를 더해서 총합 최소값으 구한다
		for (int i = 0; i < N; i++) {
			min = Math.min(min, list.get(i) + list.get(j));
			j--;
		}

		System.out.println(min);

	}

}
