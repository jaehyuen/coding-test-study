package baekjoon.구현.싸이버개강총회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		String          S   = st.nextToken();
		String          E   = st.nextToken();
		String          Q   = st.nextToken();

		Set<String>     s1  = new HashSet<>();
		Set<String>     s2  = new HashSet<>();

		String          str = null;

		while ((str = br.readLine()) != null) {
			String[] arr  = str.split(" ");
			String   time = arr[0];
			String   name = arr[1];

			// 시작시간보다 작거나 같을떄
			if (S.compareTo(time) >= 0) {
				s1.add(name);
			} else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
				// 끝나는 시간 <= 기록 <= 스트리밍 끝나는 시간
				s2.add(name);
			}
		}

		int cnt = 0;
		for (String name : s1) {
			if (s2.contains(name)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
