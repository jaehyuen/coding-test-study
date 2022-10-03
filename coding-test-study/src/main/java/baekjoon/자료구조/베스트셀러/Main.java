package baekjoon.자료구조.베스트셀러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());

		//베스트셀러 카운팅
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}

		//정렬
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (o1, o2) -> {
			
			if(o2.getValue() == o1.getValue()) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return o2.getValue() - o1.getValue();
		});

		//System.out.println(list);
		System.out.println(list.get(0).getKey());
	}

}
