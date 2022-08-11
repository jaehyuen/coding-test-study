package baekjoon.구현.NBA_농구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br      = new BufferedReader(new InputStreamReader(System.in));
		int            N       = Integer.parseInt(br.readLine());

		// 팀별 시간 및 점수 저장 배열
		Team[]         info    = { new Team(), new Team() };

		String[]       preT    = { "00", "00" };
		int            beforeT = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st   = new StringTokenizer(br.readLine());
			int             team = Integer.parseInt(st.nextToken());
			String[]        nowT = st.nextToken()
				.split(":");

			if (info[0].score > info[1].score) {
				// 1팀이 이기고있을때
				info[0].calTime(preT[0], preT[1], nowT[0], nowT[1]);

			} else if (info[0].score < info[1].score) {
				// 2팀이 이기고있을때
				info[1].calTime(preT[0], preT[1], nowT[0], nowT[1]);
			}

			// 팀 점수 증가
			info[team - 1].score++;

			preT[0] = nowT[0];
			preT[1] = nowT[1];

		}
		if (info[0].score > info[1].score) {
			// 1팀이 이겻으면 2팀 시간 증가시킴
			info[0].calTime(preT[0], preT[1], "48", "00");
		} else if (info[0].score < info[1].score) {
			// 2팀이 이겻으면 1팀 시간 증가시킴
			info[1].calTime(preT[0], preT[1], "48", "00");
		}

		System.out.println(info[0]);
		System.out.println(info[1]);

	}
}

class Team {
	int score;
	int time;
	int minute;

	public Team() {
	}

	public void calTime(String preT, String preM, String nowT, String nowM) {
		int time1   = Integer.parseInt(preT);
		int time2   = Integer.parseInt(nowT);

		int minute1 = Integer.parseInt(preM);
		int minute2 = Integer.parseInt(nowM);

		int t       = time2 - time1;
		int m       = minute2 - minute1;

		if (m < 0) {
			t--;
			m += 60;
		}
		time   += t;
		minute += m;
		if (minute >= 60) {
			time   += minute / 60;
			minute  = minute % 60;
		}
	}

	@Override
	public String toString() {
		return String.format("%02d", time) + ":" + String.format("%02d", minute);
	}

}
