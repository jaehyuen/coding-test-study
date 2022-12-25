package baekjoon.구현.참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.add(new int[] { tmp1, tmp2 });

		}

		int[] now1 = null;
		int[] next1 = null;

		int[] now2 = null;
		int[] next2 = null;

		// 격자 부분에서 들어간 부분을 찾기위해 스왑핑 진행
		while (true) {
			now1 = list.get(0);
			now2 = list.get(2);

			next1 = list.get(1);
			next2 = list.get(3);

			// 들어간부분을 찾으면 반복 종료
			if (now1[0] == now2[0] && next1[0] == next2[0]) {
				break;
			}

			list.add(now1);
			list.remove(0);
		}

		// 면적 구하기1
		int result = now1[1] * next1[1];

		// 면적 구하기2
		result += now2[1] * next2[1];

		// 면적 구하기3
		result += now1[1] * next2[1];

		// 면적에 참외 갯수 곱하기
		System.out.println(result * K);

	}
}
