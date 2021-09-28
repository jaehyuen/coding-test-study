package baekjoon.자료구조.프린터_큐;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int     N = s.nextInt();

		for (int i = 0; i < N; i++) {
			int                 page     = s.nextInt();
			int                 location = s.nextInt();
			int                 cnt      = 0;

			LinkedList<Integer> list     = new LinkedList<Integer>();

			for (int j = 0; j < page; j++) {
				list.add(s.nextInt());
			}

			for (int j = 9; j > 0; j--) {
				for (int k = 0; k < list.size(); k++) {
					if (!list.contains(j)) {
						continue;
					}

					if (list.getFirst() == j) {
						list.set(0, 0);
						cnt++;
					}

					if (list.get(location) == 0) {
						break;
					}
					list.add(list.get(0));
					list.removeFirst();

					if (location < 1) {
						location = page - 1;
					} else {
						location--;
					}
				}
			}
			System.out.println(cnt);
			list.clear();

		}
	}

}
