package baekjoon.정렬.수열_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		int             N    = Integer.parseInt(br.readLine());

		int[][]         arr1 = new int[N][2];
		int[]           arr2 = new int[N];

		StringTokenizer st   = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = i;
		}

		Arrays.sort(arr1, (o1, o2) -> {
			if (o1[0] < o2[0]) {
				return -1;
			} else if (o1[0] > o2[0]) {
				return 1;
			} else {
				if (o1[1] < o2[1]) {
					return -1;
				} else {
					return 1;
				}
			}

		});

		for (int i = 0; i < N; i++) {
			arr2[arr1[i][1]] = i;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

}
