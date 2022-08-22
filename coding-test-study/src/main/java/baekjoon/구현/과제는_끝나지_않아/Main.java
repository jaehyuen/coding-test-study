package baekjoon.구현.과제는_끝나지_않아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            N     = Integer.parseInt(br.readLine());

		int            score = 0;
		Stack<int[]>   s     = new Stack<int[]>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int             tmp = Integer.parseInt(st.nextToken());

			if (tmp == 1) {

				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				// 가장 최근 과제 시작
				T--;

				// 과제 완료시 점수 증가
				if (T == 0) {
					score += A;
				} else {
					s.push(new int[] { A, T });
				}
			} else {

				// 과제 없으면 넘어감
				if (s.isEmpty()) {
					continue;
				}

				// 과제 1분 진행
				int[] now = s.pop();
				now[1]--;

				// 과제 완료시 점수 증가
				if (now[1] == 0) {
					score += now[0];
				} else {
					s.push(now);
				}

			}

		}
		System.out.println(score);

	}
}
