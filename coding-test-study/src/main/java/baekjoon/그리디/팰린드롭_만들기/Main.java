package baekjoon.그리디.팰린드롭_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		int[]          arr = new int[26];
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		// 각 문자의 갯수를 카운팅 해준다
		for (char c : br.readLine()
			.toCharArray()) {
			arr[c - 'A']++;
		}
		int cnt = 0;
		int idx = 30;

		// 문자의 갯수가 홀수인개 2개이상이면 팰린드롭 단어를 못만든다,홀수인 단어는 인덱스를 저장한다
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				cnt++;
				idx = i;
			}

			if (cnt > 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}

		}

		ArrayList<Character> list = new ArrayList<Character>();

		// 홀수인 인덱스가 있으면 가운데 추가
		if (idx != 30) {
			list.add((char) (idx + 'A'));
			arr[idx]--;
		}

		// 알파벳 뒷자리부터 앞뒤로 단어들을 채운다
		for (int i = 25; i >= 0; i--) {
			for (int j = arr[i]; j > 0; j -= 2) {
				list.add(0, (char) (i + 'A'));
				list.add((char) (i + 'A'));
			}
		}

		for (char c : list) {
			System.out.print(c);
		}

	}

}
