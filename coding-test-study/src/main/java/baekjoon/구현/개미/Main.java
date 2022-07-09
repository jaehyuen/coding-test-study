package baekjoon.구현.개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());

		ArrayList<Ant> list = new ArrayList<>();

		// 첫번쨰 그룹 추가
		char[] tmp = br.readLine().toCharArray();
		int j = 0;
		for (int i = N1 - 1; i >= 0; i--) {
			list.add(new Ant(tmp[j], i, true));
			j++;
		}

		// 두번쨰 그룹 추가
		tmp = br.readLine().toCharArray();
		j = 0;
		for (int i = N1; i < N1 + N2; i++) {

			list.add(new Ant(tmp[j], i, false));
			j++;

		}

		int time = Integer.parseInt(br.readLine());

		// 자리 순서대로 정렬 해줌
		Collections.sort(list, (o1, o2) -> {
			return o1.idx - o2.idx;
		});

		for (int i = 0; i < time; i++) {

			// 점프 여부를 파악
			for (int k = 1; k < list.size(); k++) {

				Ant ant1 = list.get(k - 1);
				Ant ant2 = list.get(k);

				// 앞쪽 개미가 왼쪽을 보고 뒤쪽 개미가 오른쪽을 보면 둘이 자리를 바꾼다
				if (ant1.dir && !ant2.dir) {

					int tmpIdx = ant1.idx;
					ant1.idx = ant2.idx;
					ant2.idx = tmpIdx;

					list.set(k - 1, ant1);
					list.set(k, ant2);

					// 자리를 바꾸고 인덱스 증가
					k++;
				}
			}

			Collections.sort(list, (o1, o2) -> {
				return o1.idx - o2.idx;
			});

		}

		for (Ant a : list) {
			System.out.print(a.ant);
		}
		System.out.println();
	}

}

class Ant {
	char ant;
	int idx;
	boolean dir;

	public Ant(char ant, int idx, boolean dir) {
		this.ant = ant;
		this.idx = idx;
		this.dir = dir;
	}
}
