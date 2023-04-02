package baekjoon.브루트포스.팰린드롬_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		for (int i = (int) Math.ceil(str.length / 2d); i < str.length; i++) {

			// 홀수, 짝수 경우
			for (int j = 1; j >= 0; j--) {

				boolean flag = true;

				// 왼편 시작 인덱스
				int idx = i - 1 - j;

				// 반복문 범위 임시값
				int tmp = str.length - i - 1;

				// 왼편 시작 인덱스가 반복 범위를 벗어나면 넘어감
				if (idx - tmp < 0) {
					continue;
				}

				for (int k = i; k < str.length; k++) {

					// 둘이 다르면 팰린드롭 최소값이 불가능
					if (str[idx] != str[k]) {
						flag = false;
						break;
					}
					idx--;
				}

				// 범위 까지 같을때 오른쪽 위치의 2배에 홀수면 1을 빼주고 아니면 두배만 해서 팰린트롭을 만듬
				if (flag) {
					if (j == 1) {
						System.out.println((i * 2) - 1);
					} else {
						System.out.println((i * 2));
					}

					return;
				}

			}

		}

		//  반복 되는 구간이 없으면 전체 길이의 두배에 1을 뺴줌
		System.out.println((str.length * 2) - 1);

	}

}