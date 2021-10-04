package baekjoon.자료구조.나는야_포켓몬_마스터_이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> strMap = new HashMap<>();
		HashMap<String, Integer> intMap = new HashMap<>();

		for (int i = 1; i <= M + N; i++) {
			if (i <= N) {
				String str = br.readLine();
				intMap.put(str, i);
				strMap.put(i, str);
			} else {
				String str = br.readLine();
				if (isNum(str)) {
					System.out.println(strMap.get(Integer.parseInt(str)));
				} else {
					System.out.println(intMap.get(str));
				}

			}
		}
	}

	public static boolean isNum(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}