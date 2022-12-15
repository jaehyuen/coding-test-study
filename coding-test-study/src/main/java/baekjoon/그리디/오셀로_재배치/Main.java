package baekjoon.그리디.오셀로_재배치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());

			int             N    = Integer.parseInt(st.nextToken());

			char[]          arr1 = br.readLine()
				.toCharArray();
			char[]          arr2 = br.readLine()
				.toCharArray();

			// 초기, 목표 상태 흰색 갯수를 구한다
			int             cnt1 = 0;
			int             cnt2 = 0;

			// 상태가 다른 위치를 카운팅
			int             cnt3 = 0;

			for (int j = 0; j < N; j++) {

				if (arr1[j] == 'W') {
					cnt1++;
				}
				if (arr2[j] == 'W') {
					cnt2++;
				}

				if (arr1[j] != arr2[j]) {
					cnt3++;
				}

			}

			// 부족한 말은 변경해준다
			int total = Math.abs(cnt1 - cnt2);

			cnt3  -= total;

			// 자리 변경
			total += cnt3 / 2;

			System.out.println(total);

		}
	}

}
