package baekjoon.구현.복붙의_달인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {

			StringTokenizer st   = new StringTokenizer(br.readLine());

			String          str1 = st.nextToken();
			String          str2 = st.nextToken();

			int             cnt  = 0;

			// 복붙 가능하면 복붙한다
			while (str1.contains(str2)) {
				cnt++;
				str1 = str1.replaceFirst(str2, "");

			}

			// 남은 문자열 길이를 더한다
			cnt += str1.length();

			System.out.println(cnt);
		}

	}
}
