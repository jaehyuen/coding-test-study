package baekjoon.수학.너의_평점은;

import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum1 = 0;
		double sum2 = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String subject = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			if (grade.equals("P"))
				continue;

			sum1 += score;
			sum2 += score * getScore(grade);

		}

		System.out.println(sum2 / sum1);

	}

	/**
	 * 학점 점수 변환 함수
	 * 
	 * @param grade 학점 등급
	 * 
	 * @return 변환된 점수
	 */
	public static double getScore(String grade) {
		if (grade.equals("A+")) {
			return 4.5;
		} else if (grade.equals("A0")) {
			return 4.0;
		} else if (grade.equals("B+")) {
			return 3.5;
		} else if (grade.equals("B0")) {
			return 3.0;
		} else if (grade.equals("C+")) {
			return 2.5;
		} else if (grade.equals("C0")) {
			return 2.0;
		} else if (grade.equals("D+")) {
			return 1.5;
		} else if (grade.equals("D0")) {
			return 1.0;
		} else if (grade.equals("F")) {
			return 0.0;
		} else {
			return 4.0;
		}
	}

}
