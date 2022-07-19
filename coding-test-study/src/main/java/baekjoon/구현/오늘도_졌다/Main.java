package baekjoon.구현.오늘도_졌다;

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int tot1 = 0;
		int tot2 = 0;

		for (int i = 0; i < 9; i++) {
			int tmp1 = Integer.parseInt(st1.nextToken());
			int tmp2 = Integer.parseInt(st2.nextToken());

			tot1 += tmp1;

			// 이기는 순간이 있는지 확인
			if (tot1 > tot2) {
				System.out.println("Yes");
				return;
			}
			tot2 += tmp2;

		}
		System.out.println("No");

	}

}
