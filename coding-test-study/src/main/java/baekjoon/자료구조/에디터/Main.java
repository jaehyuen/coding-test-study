package baekjoon.자료구조.에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] words = br.readLine().split("");

		// 리스트 및 이터레이터 선언
		LinkedList<String> list = new LinkedList<String>();
		ListIterator<String> iter = list.listIterator();

		// 초기값 추가
		for (String word : words) {
			iter.add(word);
		}
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");

			// 커멘드별로 수행
			switch (cmd[0]) {
			case "P":
				// 문자 추가
				iter.add(cmd[1]);
				break;
			case "L":
				// 오른쪽에 값이 있으면 커서 이동
				if (iter.hasPrevious())
					iter.previous();
				break;
			case "D":
				// 왼쪽에 값이 있으면 커서 이동
				if (iter.hasNext())
					iter.next();
				break;
			case "B":
				// 커서를 뒤로 이동해서 삭제
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			default:
				break;
			}
		}

		for (String a : list) {
			sb.append(a);
		}
		System.out.println(sb.toString());
	}

}
