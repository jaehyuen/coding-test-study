package baekjoon.문자열.문자열_잘라내기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] arr = new char[R][];

		// 테이블 입력
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int start = 0;
		int end = R;

		// 이분탐색 시작
		while (start < end) {
			int mid = (start + end) / 2;

			// 해당 인덱스에서 중복이 발생하는지 체크
			if (check(R, C, arr, mid)) {
				start = mid + 1;
			} else {
				end = mid;
			}

		}

		System.out.println(start - 1);

	}

	public static boolean check(int R, int C, char[][] arr, int idx) {

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < C; i++) {
			String str = "";

			// 문자열 생성
			for (int j = idx; j < R; j++) {
				str += arr[j][i];
			}

			// 셋에 등록
			set.add(str);
		}

		// 중복이 있으면 false, 없으면 true
		if (set.size() != C) {
			return false;
		} else {
			return true;
		}
	}

}
