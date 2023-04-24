package baekjoon.문자열.늑대와_올바른_단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] arr = { 'w', 'o', 'l', 'f', 'A' };
		int[] cnt = new int[4];

		int idx = 0;

		for (int i = 0; i < str.length; i++) {
			if (arr[idx] == str[i]) {
				// 이전 위치와 같으면 카운트 증가
				cnt[idx]++;
			} else if (arr[idx + 1] == str[i]) {
				// 다음으로 와야하는 문자 체크
				cnt[++idx]++;
			} else {

				// 다음올 문자와 안맞으면 한사이클 파싱이 완료된것
				// 문자 갯수 카운팅
				if (cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3]) {
					// 4개 문자가 동일하게 나왓으면 탐색을 이어서함
					Arrays.fill(cnt, 0);
				} else {
					// 다르면 실패
					System.out.println(0);
					return;
				}

				if (str[i] == arr[0]) {
					// 다음 문자가 w 이면 탐색 지속
					idx = 0;
					cnt[idx]++;
				} else {
					// 다음 문자가 w가 아님 다른 문자가 오면 실패
					System.out.println(0);
					return;
				}

			}
		}

		if (cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3]) {
			System.out.println(1);
		} else {
			System.out.println(0);

		}

	}

}