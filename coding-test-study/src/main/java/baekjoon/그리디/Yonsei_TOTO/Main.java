package baekjoon.그리디.Yonsei_TOTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer    st   = new StringTokenizer(br.readLine());

		int                n    = Integer.parseInt(st.nextToken());
		int                m    = Integer.parseInt(st.nextToken());

		// 필요한 마일리지 리스트
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int   P   = Integer.parseInt(st.nextToken());
			int   L   = Integer.parseInt(st.nextToken());

			int[] arr = new int[P];

			// 마일리지 현황 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < P; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			// 마일리지 정렬
			Arrays.sort(arr);

			if (P - L >= 0) {
				// 여석이 부족하면 4번째로 높은 마일리지로 등록
				list.add(arr[P - L]);
			} else {
				// 여석이 남앗으면 1로 등록함
				list.add(1);
			}
		}

		Collections.sort(list);

		int total = 0;
		int cnt   = 0;
		for (int i : list) {

			// 마일리지를 전부 사용하면 종료
			if (total + i > m) {
				break;
			}
			cnt++;
			total += i;
		}

		System.out.println(cnt);
	}

}
