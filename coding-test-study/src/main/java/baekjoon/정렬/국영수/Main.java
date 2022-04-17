package baekjoon.정렬.국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Score> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Score(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}

		// 정렬 시작
		Collections.sort(list);
		for (Score s : list) {
			System.out.println(s.name);
		}

	}

}

//Comparable을 상속받아 커스텀 정렬 구현
class Score implements Comparable<Score> {
	String name;
	int kor;
	int eng;
	int math;

	public Score(String name, String kor, String eng, String math) {
		this.name = name;
		this.kor = Integer.parseInt(kor);
		this.eng = Integer.parseInt(eng);
		this.math = Integer.parseInt(math);
	}

	@Override
	public int compareTo(Score o) {

		// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 정렬
		if (this.kor == o.kor && this.eng == o.eng && this.math == o.math) {
			return this.name.compareTo(o.name);
		}

		// 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 정렬
		if (this.kor == o.kor && this.eng == o.eng) {
			return o.math - this.math;
		}

		// 국어 점수가 같으면 영어 점수가 증가하는 순서로 정렬
		if (this.kor == o.kor) {
			return this.eng - o.eng;
		}

		// 국어 점수가 감소하는 순서로 정렬
		return o.kor - this.kor;
	}
}
