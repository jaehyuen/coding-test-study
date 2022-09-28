package baekjoon.정렬.점수_계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader   br   = new BufferedReader(new InputStreamReader(System.in));

		int              sum  = 0;
		ArrayList<int[]> list = new ArrayList<int[]>();
		int[]            arr  = new int[5];

		for (int i = 1; i <= 8; i++) {
			int tmp = Integer.parseInt(br.readLine());
			//sum += tmp;
			
			list.add(new int[] { tmp, i });
		}

		Collections.sort(list, (o1, o2) -> {
			if (o2[0] == o1[0]) {
				return o1[1] - o2[1];
			}
			return o2[0] - o1[0];
		});

		for (int i = 0; i < 5; i++) {
			arr[i] = list.get(i)[1];
			sum += list.get(i)[0];

		}
		Arrays.sort(arr);
		System.out.println(sum);
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
