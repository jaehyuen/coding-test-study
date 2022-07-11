package baekjoon.수학.백대열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(":");

		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);

		int tmp = 0;
		if (a > b) {
			tmp = find(a, b);
		} else {
			tmp = find(b, a);
		}

		System.out.println((a / tmp) + ":" + (b / tmp));

	}

	public static int find(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return find(b, a % b);
	}

}
