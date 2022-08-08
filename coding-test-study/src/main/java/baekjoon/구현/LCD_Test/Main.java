package baekjoon.구현.LCD_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             s   = Integer.parseInt(st.nextToken());
		char[]          n   = st.nextToken()
			.toCharArray();

		int[][]         arr = new int[(2 * s) + 3][(s + 3) * n.length];

		for (int i = 0; i < n.length; i++) {

//			int tmp  = ((s + 2) * i) + 1;
			int tmp  = ((s + 2 + 1) * i) + 1;
			int tmp2 = ((s + 2 + 1) * i);

			// 맨위 가로
			if (n[i] != '1' && n[i] != '4') {
				for (int j = 0; j < s; j++) {
					arr[0][tmp + j] = 1;
				}
			}

			// 가운데 가로
			if (n[i] != '0' && n[i] != '1' && n[i] != '7') {

				for (int j = 0; j < s; j++) {
					arr[1 + s][tmp + j] = 1;
				}
			}

			// 맨아래 가로
			if (n[i] != '1' && n[i] != '4' && n[i] != '7') {

				for (int j = 0; j < s; j++) {
					arr[2 + (s * 2)][tmp + j] = 1;
				}
			}

			// 왼쪽 위 세로
			if (n[i] != '1' && n[i] != '2' && n[i] != '3' && n[i] != '7') {

				for (int j = 0; j < s; j++) {
					arr[1 + j][tmp2] = 2;
				}
			}

			// 오른쪽 위 세로
			if (n[i] != '5' && n[i] != '6') {

				for (int j = 0; j < s; j++) {
					arr[1 + j][tmp2 + s + 1] = 2;
				}
			}

			// 왼쪽 아래 세로
			if (n[i] == '2' || n[i] == '6' || n[i] == '8' || n[i] == '0') {

				for (int j = 0; j < s; j++) {
					arr[2 + s + j][tmp2] = 2;
				}
			}

			// 오른쪽 아래 세로
			if (n[i] != '2') {

				for (int j = 0; j < s; j++) {
					arr[2 + s + j][tmp2 + s + 1] = 2;
				}
			}

		}

		for (int[] ar : arr) {

			for (int a : ar) {
				if (a == 1) {
					System.out.print("-");
				} else if (a == 2) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}

	}
}
