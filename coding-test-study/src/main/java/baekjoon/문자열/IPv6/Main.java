package baekjoon.문자열.IPv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] tmp = str.split("::");
		String[] arr = new String[8];

		if (tmp.length == 2) {

			// 축약 체크
			String[] left = tmp[0].split(":");
			String[] right = tmp[1].split(":");

			// 중간에 축약되어있는곳 수정
			String[] mid = new String[8 - left.length - right.length];
			Arrays.fill(mid, "0000");

			// 아이피 복원
			System.arraycopy(left, 0, arr, 0, left.length);
			System.arraycopy(mid, 0, arr, left.length, mid.length);
			System.arraycopy(right, 0, arr, left.length + mid.length, right.length);

		} else if (tmp.length == 0) {

			// 모든 위치가 0 일떄
			Arrays.fill(arr, "0");
		} else {

			arr = str.split(":");
		}

		for (int i = 0; i < arr.length; i++) {

			// 0이 생략되있는 부분을 복원
			for (int j = arr[i].length(); j < 4; j++) {
				System.out.print("0");
			}

			// 마지막 위치가 아니면 뒤에 콜론을 붙여줌
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ":");
			}

		}

		// 8자리에 맞게 뒷 부분을 붙여줌
		for (int i = 8; i > arr.length; i--) {
			System.out.print(":0000");
		}

		System.out.println();

	}

}
