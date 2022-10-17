package baekjoon.문자열.서로_다른_부분_문자열의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		String          str = br.readLine();

		HashSet<String> set = new HashSet<String>();

		// 문자열을 나눠서 세에 저장
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j <= str.length() - i; j++) {
				set.add(str.substring(j, j + i));
			}
		}
		System.out.println(set.size());
	}

}
