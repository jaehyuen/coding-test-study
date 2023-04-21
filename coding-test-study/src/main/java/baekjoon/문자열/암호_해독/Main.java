package baekjoon.문자열.암호_해독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] keyStr = br.readLine().toCharArray();

		ArrayList<Key> keyList = new ArrayList<>();

		// 키를 입력
		for (int i = 0; i < keyStr.length; i++) {
			keyList.add(new Key(keyStr[i], i));
		}

		// 입력 받은 키를 문자열 단위로 정렬
		Collections.sort(keyList, (o1, o2) -> {
			return o1.c - o2.c;
		});

		char[] str = br.readLine().toCharArray();
		char[][] encodeTable = new char[str.length / keyStr.length][keyStr.length];
		char[][] decodeTable = new char[str.length / keyStr.length][keyStr.length];

		int k = 0;
		for (int i = 0; i < keyStr.length; i++) {

			// 암호화된 값을 테이블에 저장
			for (int j = 0; j < str.length / keyStr.length; j++) {
				encodeTable[j][i] = str[k++];

			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length / keyStr.length; i++) {
			int j = 0;

			// 암호화 된 값을 풀어줌
			for (Key key : keyList) {
				decodeTable[i][key.idx] = encodeTable[i][j++];
			}

			// 풀어준 값을 저장
			for (j = 0; j < keyStr.length; j++) {
				sb.append(decodeTable[i][j]);
			}

		}
		System.out.println(sb.toString());

	}
}

class Key {
	char c;
	int idx;

	Key(char c, int idx) {
		this.c = c;
		this.idx = idx;
	}
}
