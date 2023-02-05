package baekjoon.그리디.카약과_강풍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		ArrayList<Integer> list = new ArrayList<>();

		// 카약이 손상된 팀 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {

			list.add(Integer.parseInt(st.nextToken()));
		}

		// 카약을 더 가져온 팀 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			// 본인 카약이 고장나면 예비용을 사용
			if (list.contains(tmp)) {
				S--;
				list.remove(Integer.valueOf(tmp));
			} else {
				arr[tmp]++;
			}

		}

		// 정렬
		Collections.sort(list);

		for (int i : list) {

			// 앞쪽부터 탐색
			if (i > 1) {

				// 앞팀에 빌릴수있으면 빌림
				if (arr[i - 1] > 0) {
					arr[i - 1]--;

					// 고장난 팀수 감소
					S--;
					continue;

				}
			}

			// 뒤쪽 탐색
			if (i < N) {

				// 앞팀에 빌릴수있으면 빌림
				if (arr[i + 1] > 0) {
					arr[i + 1]--;

					// 고장난 팀수 감소
					S--;
					continue;

				}
			}
		}

		System.out.println(S);

	}

}
