package baekjoon.브루트포스.영의_갯수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int cnt = 0;
			for (int j = N; j <= M; j++) {

				// 숫자를 문자열로 변경후 캐릭터 배열로 변경하여 카운팅
				char[] arr = String.valueOf(j).toCharArray();
				for (char c : arr) {
					if (c == '0')
						cnt++;
				}

			}
			System.out.println(cnt);

		}

	}

}