package baekjoon.±¸Çö.IOIOI;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		int M = Integer.parseInt(sc.nextLine());

		StringBuilder sb = new StringBuilder();

		String str1 = sc.nextLine();

		for (int i = 0; i < N; i++) {
			sb.append("IO");
		}
		
		sb.append("I");
		String str2 = sb.toString();

		int result = 0;
		for (int i = 0; i <= M - str2.length(); i++) {

			if (str1.substring(i, i + (str2.length())).equals(str2)) {
				result++;
			}
		}
		System.out.println(result);
	}

}
