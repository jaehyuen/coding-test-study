package baekjoon.구현.색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            N     = Integer.parseInt(br.readLine());

		int            cnt   = 0;
		// 도화지 생성
		boolean[][]    paper = new boolean[101][101];

		for (int i = 0; i < N; i++) {

			// 색종이 시작점 입력
			StringTokenizer st = new StringTokenizer(br.readLine());

			int             x  = Integer.parseInt(st.nextToken());
			int             y  = Integer.parseInt(st.nextToken());

			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {

					// 겹쳐진곳 아니면 갯수 증가
					if (!paper[a][b]) {
						paper[a][b] = true;
						cnt++;
					}

				}
			}
		}

		System.out.println(cnt);

	}

}
