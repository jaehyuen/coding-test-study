package baekjoon.브루트포스.암호_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L;
	static int C;

	static String[] arr1;
	static String[] arr2;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr1 = new String[C];
		arr2 = new String[L];

		arr1 = br.readLine().split(" ");
		
		//알파벳 순으로 정렬
		Arrays.sort(arr1);

		find(0, 0, 0, 0);
		System.out.println(sb.toString());
	}

	public static void find(int start, int idx, int tmp1, int tmp2) {
		
		//암호 자리수가 맞춰졌을떄
		if (idx == L) {
			
			//자음이 2개, 모음이 1개 이상이면 스트링빌더에 추가
			if (tmp1 > 0 && tmp2 > 1) {
				for (String i : arr2) {
					sb.append(i);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			arr2[idx] = arr1[i];

			// 자음과 모음 카운팅
			if (arr2[idx].equals("a") || arr2[idx].equals("e") || arr2[idx].equals("i") || arr2[idx].equals("o")
					|| arr2[idx].equals("u")) {
				find(i + 1, idx + 1, tmp1 + 1, tmp2);
			} else {
				find(i + 1, idx + 1, tmp1, tmp2 + 1);
			}

		}
	}
}