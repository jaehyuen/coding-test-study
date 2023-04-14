package baekjoon.문자열.문자열_집합;

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

		// 문자열 집합 생성
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		int cnt = 0;

		// 집합에 포함 여부 체크
		for (int i = 0; i < M; i++) {
			if (set.contains(br.readLine())) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
