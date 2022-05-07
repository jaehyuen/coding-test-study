package baekjoon.브루트포스.단어_수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int tmp = 1;
			
			//자리수 별 값을 증가하여 맵에 저장한다
			for (int j = str.length() - 1; j >= 0; j--) {
				map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + tmp);
				tmp *= 10;

			}
		}
		ArrayList<Integer> list = new ArrayList<>(map.values());

		// 값을 내림차순 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2 - o1;
		});
		
		int result = 0;
		int tmp = 9;
		
		//증감값을 9부터 감소시키며 값*증감값을 결과에 저장
		for (int i : list) {
			result += (tmp) * i;
			tmp--;
		}
		System.out.println(result);

	}
}