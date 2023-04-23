package baekjoon.문자열.접두사_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();

		// 문자열 입력
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();

			// 가능한 접두사 모두 저장
			for (int j = 0; j < str.length; j++) {
				sb.append(str[j]);
				set.add(sb.toString());
			}
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			// 접두사 입력
			String prefix = br.readLine();

			if (set.contains(prefix)) {
				cnt++;
			}

		}
		System.out.println(cnt);
	}

}
