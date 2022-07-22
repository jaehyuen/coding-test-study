package baekjoon.구현.진짜_메시지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String  str    = br.readLine();
			int[]   arr    = new int[26];
			char    before = str.charAt(0);
			boolean flag   = false;

			for (int j = 0; j < str.length(); j++) {
				char word = str.charAt(j);

				// 이전단어가 한번더 사용햇는지 본다.
				if (flag) {
					// 단어가 다를떄
					if (before != word) {
						break;
					}

					arr[word - 'A'] = 0;
					flag            = false;
					continue;

				} else {
					arr[word - 'A']++;
				}

				// 3개 등장시
				if (arr[word - 'A'] == 3) {
					// 현재 단어와 플래그를 저장
					before = word;
					flag   = true;
				}

			}
			// 플래그가 활성화 됫울떄(뒤에 단어가 붙어야함)
			if (flag) {
				System.out.println("FAKE");

			} else {
				System.out.println("OK");
			}
		}
	}

}
