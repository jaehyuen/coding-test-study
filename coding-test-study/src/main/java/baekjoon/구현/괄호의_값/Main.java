package baekjoon.구현.괄호의_값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test = br.readLine()
			.split("");

		System.out.println(Arrays.toString(test));

//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}

	}

	public static int cal(int idx) {

		if (test[idx] == "(" || test[idx] == "[") {
			return cal(idx + 1);
		}

		return cal(idx + 1);

	}
}
