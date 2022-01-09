package baekjoon.이분탐색.가장_긴_증가하는_부분_수열_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));
		int                N    = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		StringTokenizer    st   = new StringTokenizer(br.readLine());
		list.add(-1);
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (list.get(list.size() - 1) < tmp) {
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
