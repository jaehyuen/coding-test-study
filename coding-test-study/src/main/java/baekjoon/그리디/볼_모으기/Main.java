package baekjoon.그리디.볼_모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] arr = br.readLine().toCharArray();

		// 파란, 빨강색 볼을 왼쪽으로 옮긴다
		int cnt1 = 0;
		int cnt2 = 0;

		boolean flag1 = false;
		boolean flag2 = false;

		// 왼쪽 공의 색갈이 아니면 바로 카운팅
		if (arr[0] == 'R') {
			flag2 = true;
		} else {
			flag1 = true;
		}

		for (int i = 1; i < arr.length; i++) {

			// 카운팅을 안하고있으면서 다른색의 볼이 나타나면 카운팅 시작하기 위해 플래그 변경
			if (!flag1 && arr[i] == 'B') {
				flag1 = true;
			}

			if (!flag2 && arr[i] == 'R') {
				flag2 = true;
			}

			if (flag1 && arr[i] == 'R') {
				cnt1++;
			}

			if (flag2 && arr[i] == 'B') {
				cnt2++;
			}

		}

		int min = Math.min(cnt1, cnt2);

		// 위에서 햇던 로직을 오른쪽에서 진행
		cnt1 = 0;
		cnt2 = 0;

		flag1 = false;
		flag2 = false;

		if (arr[arr.length - 1] == 'R') {
			flag2 = true;
		} else {
			flag1 = true;
		}

		for (int i = arr.length - 2; i >= 0; i--) {

			if (!flag1 && arr[i] == 'B') {
				flag1 = true;
			}

			if (!flag2 && arr[i] == 'R') {
				flag2 = true;
			}

			if (flag1 && arr[i] == 'R') {
				cnt1++;
			}

			if (flag2 && arr[i] == 'B') {
				cnt2++;
			}

		}
		min = Math.min(cnt1, min);
		min = Math.min(cnt2, min);

		System.out.println(min);
	}

}
