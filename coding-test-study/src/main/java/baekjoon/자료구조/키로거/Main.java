package baekjoon.자료구조.키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		// 시간단축을 위한 스트링빌더 사용
		StringBuilder  sb = new StringBuilder();

		for (int i = 0; i < T; i++) {

			// 중간 요소의 삽입, 삭제가 있기떄문에 ArrayList보다 LinkedList가 효율적
			LinkedList<Character> list = new LinkedList<Character>();
//			ArrayList<Character> list = new ArrayList<Character>();

			char[]                arr  = br.readLine().toCharArray();
			// 커서 위치 인덱스 (다음번에 입력될 위치)
			int                   idx  = 0;

			for (char c : arr) {
				switch (c) {
				// 커서(인덱스)를 왼쪽으로 이동
				case '<':
					idx--;
					break;
				// 커서(인덱스)를 오른쪽으로 이동
				case '>':
					idx++;
					break;
				// 인덱스가 0이상일때 (지울게있을떄) 삭제
				case '-':
					if (idx > 0)
						list.remove(--idx);
					break;
				// 리스트에 추가 하면서 인덱스 증가
				default:
					list.add(idx++, c);
					break;

				}

				// 인덱스의 범위 체크
				if (idx <= 0) {
					idx = 0;
				} else if (idx >= list.size()) {
					idx = list.size();
				}
			}

			for (char c : list) {
				sb.append(c);

			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

}
