package baekjoon.DP.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));
		int                N    = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-1);

		for (int i = 0; i < N; i++) {

			int tmp = Integer.parseInt(br.readLine());
			if (tmp > list.get(list.size() - 1)) {
				list.add(tmp);
			} else {
				int start = 0;
				int end   = list.size() - 1;

				while (start <= end) {
					int mid = (start + end) / 2;

					if (list.get(mid) > tmp) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}

				list.set(start, tmp);

			}

		}
		System.out.println(N - (list.size() - 1));

	}
}