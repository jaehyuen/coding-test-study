package baekjoon.그래프.알고스팟어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 위상 정렬을 위한 차수 저장 맵
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// 위상 정렬을 위한 연결 정보 저장 맵
		HashMap<Character, ArrayList<Character>> list = new HashMap<Character, ArrayList<Character>>();

		int N = Integer.parseInt(br.readLine());

		char[][] wordArr = new char[N][11];

		// 알고스팟어 입력
		for (int i = 0; i < N; i++) {
			wordArr[i] = br.readLine()
					.toCharArray();

			// 언급된 알파벳 정리
			for (int j = 0; j < wordArr[i].length; j++) {
				map.put(wordArr[i][j], 0);
			}
		}

		for (int i = 1; i < N; i++) {
			String str1 = new String(wordArr[i - 1]);
			String str2 = new String(wordArr[i]);

			// 이후에 들어온 단어가 앞 단어의 접두사면 잘못된 입력이기에 느낌표 출력
			if (str1.startsWith(str2) && !str1.equals(str2)) {
				System.out.println("!");
				return;
			}
			for (int j = 0; j < wordArr[i - 1].length; j++) {

				// 현재 단어의 길이보다 길면 멈춤
				if (j >= wordArr[i].length) {
					break;
				}

				// 해당 위치의 단어가 다르면 위상 정렬용으로 연결해준다
				if (wordArr[i - 1][j] != wordArr[i][j]) {

					// 진입 차수 증가
					map.put(wordArr[i][j], map.getOrDefault(wordArr[i][j], 0) + 1);

					// 위상 정렬용 단어 연결
					ArrayList<Character> tmpList = list.getOrDefault(wordArr[i - 1][j], new ArrayList<Character>());
					tmpList.add(wordArr[i][j]);
					list.put(wordArr[i - 1][j], tmpList);
					break;
				}
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();

		for (Entry<Character, Integer> m : map.entrySet()) {

			// 사전순 맨 앞이면 큐에 추가
			if (m.getValue() == 0) {
				q.add(new int[] { m.getKey(), 0 });
			}

		}
		// 사전순 맨 앞에 나오는 알파벳이 여러개면 물음표 출력
		if (q.size() > 2) {
			System.out.println("?");
			return;
		}

		ArrayList<int[]> result = new ArrayList<int[]>();

		// 위상 정렬
		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 결과에 저장
			result.add(now);

			for (char next : list.getOrDefault((char) now[0], new ArrayList<Character>())) {
				map.put(next, map.getOrDefault(next, 0) - 1);

				if (map.get(next) == 0) {
					q.add(new int[] { next, now[1] + 1 });
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		if (result.size() != map.size()) {

			// 모든 단어를 위상정렬 수행 불가시 느낌표 출력
			System.out.println("!");
		} else {
			int prev = -1;

			for (int[] c : result) {

				// 우선순위가 똑같은 알파벳이 있다면 답이 여러개므로 물을표 출력
				if (prev == c[1]) {
					System.out.println("?");
					return;
				}
				prev = c[1];
				sb.append((char) c[0]);
			}
			System.out.println(sb.toString());
			System.out.println();
		}

	}

}
