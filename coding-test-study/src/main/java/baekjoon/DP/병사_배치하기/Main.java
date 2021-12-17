package baekjoon.DP.병사_배치하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));
		int                N    = Integer.parseInt(br.readLine());
		int[]              arr  = new int[N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer    st   = new StringTokenizer(br.readLine());

		list.add(Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (list.get(list.size() - 1) > arr[i]) {
				list.add(arr[i]);
			} else {
				int start = 1;
				int end   = list.size() - 1;

				while (start <= end) {
					int mid = (start + end) / 2;

					if (list.get(mid) > arr[i]) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
				list.set(start, arr[i]);
			}

		}

		System.out.println(N - list.size() + 1);

	}

}
