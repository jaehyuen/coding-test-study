package baekjoon.구현.분수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());

		int tmp = 1;
		int i = 0;
		int idx = 2;

		// 기준값 근방 위치를 찾을때까지 반복
		while (tmp < X) {

			// 임시값 증가14
			tmp += idx;

			// 증감값 증가
			idx++;

			// 인덱스 증가
			i++;
		}

		int x = 0;
		int y = 0;

		if (i % 2 == 1) {
			// 홀수일때 왼쪽 아래에서 오른쪽 위쪽으로 올라감

			x = i;
			while (x >= 0) {
				if (tmp == X) {
					break;
				}
				tmp--;
				x--;
				y++;
			}
		} else {

			// 짝수일때 오른쪽 위쪽에서 왼쪽 아래로 내려감
			y = i;
			while (x >= 0) {
				if (tmp == X) {
					break;
				}
				tmp--;
				x++;
				y--;
			}
		}

		System.out.println((x + 1) + "/" + (y + 1));

	}

}
