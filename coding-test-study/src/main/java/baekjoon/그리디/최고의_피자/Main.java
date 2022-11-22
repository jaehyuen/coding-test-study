package baekjoon.그리디.최고의_피자;

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
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());

		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             A   = Integer.parseInt(st.nextToken());
		int             B   = Integer.parseInt(st.nextToken());
		int             C   = Integer.parseInt(br.readLine());

		int[]           arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}

		// 토핑 열량을 정렬
		Arrays.sort(arr);

		// 모우만 있을때 계산
		int    max = (int) Math.floor(C / A);
		double sum = C;
		int    j   = 0;

		// 열량이 높은 토핑부터 넣으면서 최대값 체크
		for (int i = N - 1; i >= 0; i--) {

			j++;
			sum += arr[i];

			int tmp = (int) Math.floor(sum / (A + B * j));

			if (tmp >= max) {
				max = tmp;
			} else {
				break;
			}
		}

		System.out.println(max);

	}

}
