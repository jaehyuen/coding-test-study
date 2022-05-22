package baekjoon.브루트포스.DNA;

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] dnaArr = new String[N];

		for (int i = 0; i < N; i++) {
			dnaArr[i] = br.readLine();
		}

		int[][] cnt = new int[M][26];
		// 문자를 카운팅 한다, 카운팅이 높은 문자열로 문자를 만든다
		for (int i = 0; i < N; i++) {
			char[] arr = dnaArr[i].toCharArray();
			for (int j = 0; j < M; j++) {
				cnt[j][arr[j] - 'A']++;
			}
		}

		// 문자열을 만든다
		String resultStr = "";
		int resultCnt = 0;
		for (int i = 0; i < M; i++) {

			int max = cnt[i][0];
			char c = 'A';
			for (int j = 0; j < 26; j++) {
				if (max < cnt[i][j]) {
					max = cnt[i][j];
					c = (char) ('A' + j);
				}
			}

			// 다른 갯수를 카운팅
			resultStr += c;
			resultCnt += N - max;
		}

		System.out.println(resultStr);
		System.out.println(resultCnt);
	}
}