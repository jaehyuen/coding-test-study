package baekjoon.자료구조.통계학;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int arr[] = new int[N];
		HashMap<Integer, Integer> testMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
			testMap.put(arr[i], testMap.getOrDefault(arr[i], 0) + 1);
		}

		Arrays.sort(arr);
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(testMap.entrySet());
		Collections.sort(list, (o1, o2) -> {
			if (o2.getValue() == o1.getValue()) {
				return o1.getKey() - o2.getKey();
			}
			return o2.getValue() - o1.getValue();
		});

		System.out.println(Math.round(Arrays.stream(arr).average().getAsDouble()));
		System.out.println(arr[arr.length / 2]);
		if (list.size() == 1) {
			System.out.println(list.get(0).getKey());
		} else {
			System.out.println(
					list.get(0).getValue() == list.get(1).getValue() ? list.get(1).getKey() : list.get(0).getKey());
		}

		System.out.println(arr[arr.length - 1] - arr[0]);

	}

}
