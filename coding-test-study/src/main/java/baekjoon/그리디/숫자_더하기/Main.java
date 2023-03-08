package baekjoon.그리디.숫자_더하기;

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

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> q = new PriorityQueue<Integer>();

			int zeroCnt = 0;
			int result = 0;
			// 0이 입력되면 반복 종료
			if (N == 0) {
				break;
			}

			// 숫자 입력
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());

				// 0이 들어오면 임시로 카운팅
				if (tmp == 0) {
					zeroCnt++;
				} else {
					q.add(tmp);
				}

			}

			// 제일 큰자리수 2개를 뺴줌
			int num1 = q.poll();
			int num2 = q.poll();
			int idx = N / 2;

			if (N % 2 == 0) {
				// 짝수일때
				idx--;
				result += num1 * Math.pow(10, idx);
				result += num2 * Math.pow(10, idx);

			} else {
				// 홀수일떄는 젤 작은 수가 첼 큰 자리수를 차지함
				result += num1 * Math.pow(10, idx);
				result += num2 * Math.pow(10, idx - 1);

			}
			idx--;

			// 0 채우기
			for (int i = 0; i < zeroCnt; i++) {
				q.add(0);
			}

			// 홀수일때 짝을 맞춰준다
			if (N % 2 == 1) {
				result += q.poll() * Math.pow(10, idx);
				idx--;
			}

			while (!q.isEmpty()) {
				// 2개씩 더해줌
				num1 = q.poll();
				num2 = q.poll();

				result += num1 * Math.pow(10, idx);
				result += num2 * Math.pow(10, idx);
				idx--;
			}
			System.out.println(result);

		}

	}

}
