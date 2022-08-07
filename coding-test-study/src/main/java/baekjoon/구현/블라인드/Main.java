package baekjoon.구현.블라인드;

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		char[][] arr = new char[(M * 5)][(N * 5) + 1];
		int[] result = new int[5];

		// 첫라인은 삭제
		br.readLine();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().toCharArray();

			// 한층을 입력받았을떄
			if (i != 0 && arr[i][1] == '#') {

				// 같은 층의 블라인드 파악
				for (int j = 0; j < N * 5; j += 5) {

					// 블라인드 확인
					for (int k = 0; k < 4; k++) {

						// 블라인드가 다 내려졌을떄
						if (k == 3 && arr[i - 1][j + 1] == '*') {
							result[k + 1]++;
							System.out.println("??????");
							break;
						} else if (arr[i - 4 + k][j + 1] != '*') {

							// 해당위치에 블라인드가 없으면 그만
							// System.out.println("K : "+k);
							result[k]++;
							break;
						}

					}

				}
				// System.out.println("------------------");
			}

		}

		for (int i = 0; i < 5; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
