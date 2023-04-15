package baekjoon.문자열.파일_정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			// 점을 기준으로 문자열 분리
			String[] str = br.readLine().split("\\.");

			// 확장자별 카운팅
			map.put(str[1], map.getOrDefault(str[1], 0) + 1);
		}

		ArrayList<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		// 확장자를 사전순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o1.getKey().compareTo(o2.getKey());
		});

		for (Entry<String, Integer> e : list) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

}
