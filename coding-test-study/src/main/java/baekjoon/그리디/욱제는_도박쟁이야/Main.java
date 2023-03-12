package baekjoon.그리디.욱제는_도박쟁이야;

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

		int sum = 0;

		// 모든 입력에 대해 양수로 변경해서 더하면 답이 나옴
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				// 절대값을 전부 입력해준다
				sum += Math.abs(Integer.parseInt(st.nextToken()));
			}
		}

		System.out.println(sum);

	}

}
