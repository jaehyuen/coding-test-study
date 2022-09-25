package baekjoon.문자열.비밀_편지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] arr = br.readLine().toCharArray();

			//한변의 길이 조회
			int tmp = (int) Math.sqrt(arr.length);

			//해독해서 출력
			for (int a = tmp - 1; a >= 0; a--) {
				for (int b = 0; b < tmp; b++) {
					System.out.print(arr[a + (tmp * b)]);
				}
			}
			System.out.println();
		}
	}
}
