package baekjoon.구현.수강신청;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader           br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer          st  = new StringTokenizer(br.readLine());

		int                      K   = Integer.parseInt(st.nextToken());
		int                      L   = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<String, Integer>();


		for (int i = 0; i < L; i++) {
			String num = br.readLine();

			// 우선순위를 계속 업데이트 해준다
			map.put(num, i);

		}

		// 우선순위로 정렬
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		list.sort((o1, o2) -> {
			return o1.getValue() - o2.getValue();
		});

		// 제한 인원, 신청인원을 비교하여 출력 갯수를 정한다
		int size = K < list.size() ? K : list.size();

		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i)
				.getKey());

		}
	}

}
