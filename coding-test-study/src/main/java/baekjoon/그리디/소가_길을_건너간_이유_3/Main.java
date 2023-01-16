package baekjoon.그리디.소가_길을_건너간_이유_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader   br   = new BufferedReader(new InputStreamReader(System.in));
		int              N    = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());

			int             tmp1 = Integer.parseInt(st.nextToken());
			int             tmp2 = Integer.parseInt(st.nextToken());

			list.add(new int[] { tmp1, tmp2 });

		}

		// 입력값 정렬
		Collections.sort(list, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int time = 0;
		for (int i = 0; i < N; i++) {
			int[] now = list.get(i);

			// 도착시간이 아직 안됫으면 시간 변경
			if (time < now[0]) {
				time = now[0];
			}
			time += now[1];

		}

		System.out.println(time);

	}

}
