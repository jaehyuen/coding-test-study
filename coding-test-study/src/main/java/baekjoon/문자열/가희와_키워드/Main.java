package baekjoon.문자열.가희와_키워드;

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

		// 키워드 입력
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			// 작성할 키워드 입력
			String[] strArr = br.readLine().split(",");

			// 키워드 셋에서 지워줌
			for (String str : strArr) {
				set.remove(str);
			}

			sb.append(set.size() + "\n");

		}
		System.out.println(sb.toString());
	}

}
