package baekjoon.정렬.로프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 로프를 저장하는 리스트
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// 리스트를 정렬한다
		Collections.sort(list);

		int max = Integer.MIN_VALUE;

		// 처음부터 로프갯수를 줄여가며 중량을 비교
		for (int i = 0; i < N; i++) {

			int w = list.get(0) * list.size();
			max = Math.max(max, w);
			list.remove(0);

		}
		System.out.println(max);
	}

}
