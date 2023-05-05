package baekjoon.문자열.앵무새;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[][] arr = new String[N][];
		int[] idx = new int[N];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
			cnt += arr[i].length;
		}

		String[] str = br.readLine().split(" ");

		// 앵무새가 말한 단어의 합과 받아 적은 단어의 합이 같은지 판단
		if (cnt != str.length) {
			System.out.println("Impossible");
			return;
		}

		for (String s : str) {

			boolean flag = false;

			for (int i = 0; i < N; i++) {

				// i번 앵무새가 말한 단어를 다 안썻을떄
				if (idx[i] < arr[i].length) {

					if (arr[i][idx[i]].equals(s)) {
						idx[i]++;
						flag = true;
						break;
					}
				}
			}

			// 앵무새가 말한 단어가 적혀있으면 다음단어 체크
			if (!flag) {
				System.out.println("Impossible");
				return;
			}
		}
		System.out.println("Possible");
	}
}
