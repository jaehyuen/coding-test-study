package baekjoon.구현.사과_담기_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());
		int             j   = Integer.parseInt(br.readLine());

		// 현재위치
		int             now = 1;
		int             cnt = 0;

		for (int i = 0; i < j; i++) {
			int apple  = Integer.parseInt(br.readLine());
			int basket = (now + M - 1);

			// 가까운쪽으로 움직임
			if (apple < now) {
				cnt += now - apple;
				now  = apple;
			} else if (apple > basket) {
				cnt += apple - basket;
				now += apple - basket;
			}
		}

		System.out.println(cnt);
	}

}
