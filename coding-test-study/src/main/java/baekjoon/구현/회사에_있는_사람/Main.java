package baekjoon.구현.회사에_있는_사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, String> map = new HashMap<>();

		// 로그 입력
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			map.put(input[0], input[1]);
		}

		ArrayList<String> list = new ArrayList<>();
		for (Entry<String, String> m : map.entrySet()) {

			// 퇴근 안한 사람이면 리스트에 추가
			if (m.getValue().equals("enter")) {
				list.add(m.getKey());
			}
		}
		
		//사전 역순으로 정렬
		Collections.sort(list, Collections.reverseOrder());

		for (String s : list) {
			System.out.println(s);
		}

	}
}
