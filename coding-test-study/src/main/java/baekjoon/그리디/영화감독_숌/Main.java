package baekjoon.그리디.영화감독_숌;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s   = new Scanner(System.in);

		int     N   = Integer.parseInt(s.nextLine());

		int     cnt = 0;
		int     tmp = 0;
		while (cnt < N) {
			tmp++;
			if (String.valueOf(tmp).contains("666")) {
				cnt++;
			}

		}
		System.out.println(tmp);

	}

}
