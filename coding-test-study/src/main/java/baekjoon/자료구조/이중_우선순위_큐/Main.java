package baekjoon.자료구조.이중_우선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			int                    k   = Integer.parseInt(br.readLine());
			TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();

			for (int j = 0; j < k; j++) {
				StringTokenizer st   = new StringTokenizer(br.readLine());
				String          func = st.nextToken();
				long            idx  = Long.parseLong(st.nextToken());

				if (func.equals("I")) {

					map.put(idx, map.getOrDefault(idx, 0) + 1);
				} else if (func.equals("D") && idx == 1 && !map.isEmpty()) {
					int tmp = map.getOrDefault(map.lastKey(), 0);
					if (tmp == 0)
						continue;

					if (tmp == 1) {
						map.remove(map.lastKey());
					} else {
						map.put(map.lastKey(), tmp - 1);
					}

				} else if (func.equals("D") && idx == -1 && !map.isEmpty()) {
					int tmp = map.getOrDefault(map.firstKey(), 0);

					if (tmp == 0)
						continue;

					if (tmp == 1) {
						map.remove(map.firstKey());
					} else {
						map.put(map.firstKey(), tmp - 1);
					}
				}
			}

			if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
			}

		}
		System.out.println(sb.toString());

	}

}
