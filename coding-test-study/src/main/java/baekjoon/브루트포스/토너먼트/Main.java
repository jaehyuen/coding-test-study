package baekjoon.브루트포스.토너먼트;

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

		// 선수가 짝수면 증가 시켜준다
		N = N % 2 == 0 ? N : N + 1;

		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		// 토너먼트 배열에 선수들을 저장한다
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}


		int round = 0;
		while (true) {

			// 라운드 증가
			round++;
			int idx = 0;

			// 두명씩 경기를 진행
			for (int i = 0; i < N; i += 2) {

				int tmp = 0;
				if ((arr[i] == kim && arr[i + 1] == lim) || (arr[i] == lim && arr[i + 1] == kim)) {
					System.out.println(round);
					return;
				} else if (arr[i] == kim || arr[i] == lim) {
					tmp = arr[i];
				} else {
					tmp = arr[i + 1];
				}

				//기존값을 초기화 하고 승리자를 인덱스 자리에 넣는
				arr[i] = -1;
				arr[i + 1] = -1;
				arr[idx] = tmp;

				idx++;

			}


			// 선수들을 반으로 나눈다
			N = (int) Math.ceil(N / 2f);

			// 대결을 못하면 -1 출력(사실상 의미없음)
			if (N == 1) {
				System.out.println(-1);
				return;
			}

		}

	}
}