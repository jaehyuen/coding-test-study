package baekjoon.그리디.비트_우정지수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			char[] N = st.nextToken().toCharArray();
			char[] M = st.nextToken().toCharArray();

			int cnt1 = 0;
			int cnt2 = 0;

			int difCnt = 0;

			for (int j = 0; j < N.length; j++) {

				// 0 갯수 카운팅
				if (N[j] == '0') {
					cnt1++;
				}

				if (M[j] == '0') {
					cnt2++;
				}

				// 비트가 다르면 카운트 증가
				if (N[j] != M[j]) {
					difCnt++;
				}

			}

			int result = 0;

			// 임의의 자리수를 변경한다
			result += Math.abs(cnt1 - cnt2);

			// 남은곳은 서로 다른자리를 교환한다
			result += (difCnt - result) / 2;

			sb.append(result + "\n");
		}

		System.out.println(sb.toString());
	}

}
