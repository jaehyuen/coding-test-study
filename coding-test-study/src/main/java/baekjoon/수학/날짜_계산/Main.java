package baekjoon.수학.날짜_계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());
		int             E1     = Integer.parseInt(st.nextToken());
		int             S1     = Integer.parseInt(st.nextToken());
		int             M1     = Integer.parseInt(st.nextToken());

		int             E2     = 1, S2 = 1, M2 = 1;

		int             result = 0;
		
		//하나씩 비교하며 답을 찾는다
		while (true) {
			result++;

			if (E1 == E2 && S1 == S2 && M1 == M2) {
				System.out.println(result);
				break;
			}

			E2++;
			S2++;
			M2++;

			if (E2 == 16)
				E2 = 1;
			if (S2 == 29)
				S2 = 1;
			if (M2 == 20)
				M2 = 1;

		}
	}
}
