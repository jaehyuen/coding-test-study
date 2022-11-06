package baekjoon.그리디.뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int[] cnt = new int[2];

		for (int i = 0; i < arr.length - 1; i++) {

			// 이어져있는 구간을 카운팅
			if (arr[i] != arr[i + 1]) {
				cnt[arr[i] - '0']++;
			}

		}
		// 마지막 부분도 카운팅
		cnt[arr[arr.length - 1] - '0']++;

		// 최소값을 출력
		System.out.println(Math.min(cnt[0], cnt[1]));

	}

}
