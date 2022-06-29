package baekjoon.정렬.아시아_정보올리피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader            br   = new BufferedReader(new InputStreamReader(System.in));
		int                       N    = Integer.parseInt(br.readLine());

		ArrayList<Score>          list = new ArrayList<Score>();
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Score(st.nextToken(), st.nextToken(), st.nextToken()));
		}

		// 점수 내림차순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2.score - o1.score;
		});

		int cnt = 0;
		for (Score s : list) {

			// 메달 3개를 출력하면 종료
			if (cnt > 2) {
				break;
			}

			// 한 국가가 2개 이상 받으면 다음 순위로 진행
			int tmp = map.getOrDefault(s.con, 0);
			if (tmp > 1)
				continue;

			map.put(s.con, tmp + 1);
			System.out.println(s.con + " " + s.num);
			cnt++;

		}

	}

}

//
class Score {
	int con;
	int num;
	int score;

	public Score(String con, String num, String score) {
		this.con   = Integer.parseInt(con);
		this.num   = Integer.parseInt(num);
		this.score = Integer.parseInt(score);
	}

}
