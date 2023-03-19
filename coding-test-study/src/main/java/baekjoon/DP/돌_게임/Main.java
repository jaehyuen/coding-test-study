package baekjoon.DP.돌_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}

	}

}
