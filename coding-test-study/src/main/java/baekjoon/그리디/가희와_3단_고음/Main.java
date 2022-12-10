package baekjoon.그리디.가희와_3단_고음;

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

		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		// 현재 고음 위치
		int idx = A;
		int cnt = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());

			// 고음위치랑 현재 음이랑 같으면 카운트 증가 및 다음 고음 위치 저장
			if (now == idx) {
				cnt++;
				idx += D;
			}
		}

		System.out.println(cnt);

	}

}
