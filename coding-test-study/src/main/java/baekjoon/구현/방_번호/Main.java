package baekjoon.구현.방_번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받은 숫자를 배열로 쪼갠다
		char[] arr = br.readLine().toCharArray();

		// 카운팅할 맵 선언
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// 9,6은 같이 카운팅
		for (char a : arr) {
			if (a == '9') {
				map.put('6', map.getOrDefault('6', 0) + 1);
			} else {
				map.put(a, map.getOrDefault(a, 0) + 1);
			}
		}

		// 6을 반을 반으로 나눠준다(6,9를 같이 카운팅했기 때문)
		map.put('6', (map.getOrDefault('6', 0)+1) / 2);

		int result = 0;
		// 가장 큰값이 답이다
		for (int i : map.values()) {
			result = Math.max(i, result);
		}

		System.out.println(result);

	}
}
