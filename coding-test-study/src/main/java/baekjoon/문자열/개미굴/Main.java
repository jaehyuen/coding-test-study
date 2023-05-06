package baekjoon.문자열.개미굴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie(0, "");

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			String str;
			Trie now = trie;

			// 순차적으로 입력
			for (int j = 0; j < K; j++) {
				str = st.nextToken();
				now = now.add(str);
			}
		}

		trie.print();

	}

}

class Trie {
	private int idx;
	private HashMap<String, Trie> map = new HashMap<>();

	Trie(int idx, String str) {
		this.idx = idx;
	}

	public void print() {

		// 맵의 키를 알파벳 순으로 정렬
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		for (String key : list) {

			// 층 단위 입력
			for (int i = 0; i < idx; i++) {
				System.out.print("--");
			}
			System.out.println(key);

			// 다음 층 탐색
			map.get(key).print();

		}

	}

	public Trie add(String str) {

		Trie newTrie = map.get(str);

		// 맵에 없으면 추가
		if (newTrie == null) {
			newTrie = new Trie(idx + 1, str);
			map.put(str, newTrie);
		}
		return newTrie;

	}
}
