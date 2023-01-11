package baekjoon.그리디.오리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		char[]         str   = br.readLine()
			.toCharArray();
		char[]         duck  = { 'q', 'u', 'a', 'c', 'k' };

		int            cnt   = 0;
		int            total = str.length;

		while (true) {
			int[]   tmp     = new int[5];
			int     duckIdx = 0;
			boolean flag    = false;

			for (int i = 0; i < str.length; i++) {

				// 위치가 같으면
				if (str[i] == duck[duckIdx]) {
					// 인덱스 저장
					tmp[duckIdx] = i;
					duckIdx++;
				}

				// 초기화
				if (duckIdx == 5) {
					duckIdx = 0;

					// 울음소리 지워주기
					for (int j : tmp) {
						str[j] = ' ';
					}
					flag   = true;

					// 남은겟수 차감
					total -= 5;
				}
			}

			// 완전한 울음소리를 못찾으면 그만
			if (!flag) {
				break;
			}
			cnt++;

		}

		// 녹음본이 이상할떄
		if (total > 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt == 0 ? -1 : cnt);
		}

	}

}
