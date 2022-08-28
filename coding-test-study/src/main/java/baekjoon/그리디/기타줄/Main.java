package baekjoon.그리디.기타줄;

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			// 패키지 가격보다 단풍 * 6 가격이 싸면 체인지
			tmp1 = tmp1 < tmp2 * 6 ? tmp1 : tmp2 * 6;

			list.add(new int[] { tmp1, tmp2 });
		}

		int result = 0;
		int[] pack = null;
		int cost = 0;

		// 패키지 가격이 가장 저렴한걸 뽑는다
		Collections.sort(list, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		pack = list.get(0);

		// 비용 계산
		cost = (N / 6) * pack[0];

		// 결과에 추가
		result += cost;

		cost = pack[0];

		N %= 6;

		// 단품 가격이 가장 저렴한걸 찾는다
		Collections.sort(list, (o1, o2) -> {
			return o1[1] - o2[1];
		});

		pack = list.get(0);

		// 패키지랑, 단품가격중 싼거를 고른다
		cost = Math.min(cost, N * pack[1]);

		result += cost;

		System.out.println(result);

	}

}
