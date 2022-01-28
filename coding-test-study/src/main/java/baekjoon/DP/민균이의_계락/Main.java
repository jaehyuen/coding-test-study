package baekjoon.DP.민균이의_계락;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));

		int                N    = Integer.parseInt(br.readLine());
		StringTokenizer    st   = new StringTokenizer(br.readLine());

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-1);

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			if (tmp > list.get(list.size() - 1)) {
				list.add(tmp);
			} else {
				int start = 1;
				int end   = list.size() - 1;

				while (start <= end) {
					int mid = (start + end) / 2;

					if (list.get(mid) >= tmp) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}
				list.set(start, tmp);

			}

		}
		System.out.println(list.size() - 1);
	}
}