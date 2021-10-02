package baekjoon.ÀÚ·á±¸Á¶.ÆÐ¼Ç¿Õ_½ÅÇØºó;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();

				hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);

			}
			int sum = 1;
			for (int in : hashMap.values()) {
				sum *= (in + 1);

			}

			System.out.println(sum - 1);
			hashMap.clear();
		}

	}

}
