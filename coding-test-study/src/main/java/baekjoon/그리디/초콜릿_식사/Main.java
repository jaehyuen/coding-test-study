package baekjoon.그리디.초콜릿_식사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int size = 1;

		// 가장 작은 초콜릿 크기를 구한다
		while (size < K) {
			size *= 2;
		}

		System.out.print(size);

		int cnt = 0;

		// K = 줘야하는 초콜릿 갯수
		while (K > 0) {

			// 현재 사이즈가 K보다 작으면 현재 사이즈를 준다
			if (size <= K) {
				K -= size;
			}

			// 남은 한조각을 반으로 나눈다
			size /= 2;

			// 쪼개진 카운트 증가
			cnt++;

		}

		System.out.println(" " + (cnt - 1));

	}

}
