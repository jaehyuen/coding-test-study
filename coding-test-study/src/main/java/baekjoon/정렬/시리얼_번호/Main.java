package baekjoon.정렬.시리얼_번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int            N    = Integer.parseInt(br.readLine());

		ArrayList<Num> list = new ArrayList<Num>();

		for (int i = 0; i < N; i++) {
			list.add(new Num(br.readLine()));
		}

		// 정렬
		Collections.sort(list);

		for (Num n : list) {
			System.out.println(n.number);
		}

	}

}

class Num implements Comparable<Num> {
	String number;

	public Num(String number) {
		this.number = number;
	}

	@Override
	public int compareTo(Num o) {
		// 길이가 같으면 숫자인걸 다 더해서 비교
		if (number.length() == o.number.length()) {
			int    tmp1 = 0;
			int    tmp2 = 0;

			char[] arr1 = number.toCharArray();
			char[] arr2 = o.number.toCharArray();

			for (int i = 0; i < number.length(); i++) {
				if (arr1[i] >= '0' && arr1[i] <= '9') {
					tmp1 += arr1[i] - '0';
				}

				if (arr2[i] >= '0' && arr2[i] <= '9') {
					tmp2 += arr2[i] - '0';
				}
			}

			if (tmp1 == tmp2) {
				return number.compareTo(o.number);
			}
			return tmp1 - tmp2;
		} else {
			return number.length() - o.number.length();
		}
	}

}
