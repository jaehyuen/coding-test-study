package baekjoon.그리디.배수_스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {

			// 스위치가 켜저있으면 끈다
			if (arr[i] == 'Y') {
				cnt++;

				// i에 대한 전구를 반전시킨다
				for (int j = i; j < arr.length; j += i + 1) {
					arr[j] = arr[j] == 'Y' ? 'N' : 'Y';
				}
			}
		}

		System.out.println(cnt);
	}
}