package baekjoon.구현.짐_챙기는_숀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		// 책이 없으면 0 리턴
		if (N == 0) {
			System.out.println(0);
			return;
		}

		st = new StringTokenizer(br.readLine());

		int cnt = 1;
		int now = 0;

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			// 책을 더 담을수 있는 경우
			if (now + tmp <= M) {
				now += tmp;
			} else {
				// 새로운 박스에 담는다
				cnt++;
				now = tmp;
			}
		}
		System.out.println(cnt);
	}
}
