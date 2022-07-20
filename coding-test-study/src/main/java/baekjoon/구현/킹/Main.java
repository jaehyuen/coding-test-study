package baekjoon.구현.킹;

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

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		// 킹, 돌 위치 저장 배열

		int[][]         arr = new int[2][2];

		char[]          loc = st.nextToken()
			.toCharArray();

		// 킹 위치
		arr[0][1] = loc[0] - 'A';
		arr[0][0] = loc[1] - '0' - 1;

		loc       = st.nextToken()
			.toCharArray();
		// 돌 위치
		arr[1][1] = loc[0] - 'A';
		arr[1][0] = loc[1] - '0' - 1;

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			
//			for (int[] ar : arr) {
//				System.out.println(Arrays.toString(ar));
//			}
//			System.out.println();
			
			String  fuc  = br.readLine();
			int[][] next = new int[2][2];

			next[0][0] = arr[0][0];
			next[0][1] = arr[0][1];
			next[1][0] = arr[1][0];
			next[1][1] = arr[1][1];

			// 킹, 돌위치를 이동시킴
			switch (fuc) {
			case "T":
				next[0][0]++;
				next[1][0]++;
				break;
			case "B":
				next[0][0]--;
				next[1][0]--;
				break;
			case "R":
				next[0][1]++;
				next[1][1]++;
				break;
			case "L":
				next[0][1]--;
				next[1][1]--;
				break;
			case "RT":
				next[0][0]++;
				next[1][0]++;

				next[0][1]++;
				next[1][1]++;
				break;
			case "LT":
				next[0][0]++;
				next[1][0]++;

				next[0][1]--;
				next[1][1]--;
				break;
			case "RB":
				next[0][0]--;
				next[1][0]--;

				next[0][1]++;
				next[1][1]++;
				break;
			case "LB":
				next[0][0]--;
				next[1][0]--;

				next[0][1]--;
				next[1][1]--;
				break;
			default:
				break;
			}

			// 체스판을 벗어나면 무시
			if (next[0][0] < 0 || next[0][0] >= 8 || next[0][1] < 0 || next[0][1] >= 8) {
				continue;
			}

			// 킹이 움직인 위치에 돌이있으면
			if (next[0][0] == arr[1][0] && next[0][1] == arr[1][1]) {
				// 체스판을 벗어나면 무시
				if (next[1][0] < 0 || next[1][0] >= 8 || next[1][1] < 0 || next[1][1] >= 8) {
					continue;
				}
				arr[0][0] = next[0][0];
				arr[0][1] = next[0][1];
				arr[1][0] = next[1][0];
				arr[1][1] = next[1][1];
			} else {
				arr[0][0] = next[0][0];
				arr[0][1] = next[0][1];
			}

		}

		// 위치 출력
		for (int[] ar : arr) {
			System.out.println((char) (ar[1] + 'A') + "" + (ar[0] + 1));
		}

	}

}
