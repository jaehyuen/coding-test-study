package baekjoon.구현.로마_숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");

		map.put(4, "IV");
		map.put(9, "IX");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] romNum = new String[2];
		int[] num = new int[2];

		romNum[0] = br.readLine();
		romNum[1] = br.readLine();

		for (int i = 0; i < 2; i++) {

			// 1000 자릿수 지환
			while (romNum[i].startsWith("M")) {
				romNum[i] = romNum[i].replaceFirst("M", "");
				num[i] += 1000;
			}

			for (int j = 2; j >= 0; j--) {

				// 자리수별 임시값 선언
				int tmp = (int) Math.pow(10, j);

				if (tmp == 0) {
					tmp = 1;
				}

				// 9 * tmp 수정
				if (romNum[i].startsWith(map.get(tmp * 9))) {
					romNum[i] = romNum[i].replace(map.get(tmp * 9), "");
					num[i] += tmp * 9;
				}

				// 5 * tmp 수정
				if (romNum[i].startsWith(map.get(tmp * 5))) {
					romNum[i] = romNum[i].replace(map.get(tmp * 5), "");
					num[i] += tmp * 5;
				}

				// 4 * tmp 수정
				if (romNum[i].startsWith(map.get(tmp * 4))) {
					romNum[i] = romNum[i].replace(map.get(tmp * 4), "");
					num[i] += tmp * 4;
				}

				// 1 * tmp 수정
				while (romNum[i].startsWith(map.get(tmp * 1))) {
					romNum[i] = romNum[i].replaceFirst(map.get(tmp * 1), "");
					num[i] += tmp * 1;
				}

			}

		}
		String resultStr = "";
		int resultNum = num[0] + num[1];
		System.out.println(resultNum);

		// 1000 자릿수 치환
		for (int j = 0; j < resultNum / 1000; j++) {
			resultStr += "M";
		}
		resultNum %= 1000;

		// 나머지 자릿수 치환
		for (int j = 2; j >= 0; j--) {

			// 자리수별 임시값 선언
			int tmp = (int) Math.pow(10, j);

			if (tmp == 0) {
				tmp = 1;
			}

			// 9 * tmp 수정
			if (resultNum / tmp == 9) {
				resultStr += map.get(tmp * 9);
				resultNum -= tmp * 9;
			}

			// 5 * tmp 수정
			if (resultNum / tmp >= 5) {
				resultStr += map.get(tmp * 5);
				resultNum -= tmp * 5;
			}

			// 4 * tmp 수정
			if (resultNum / tmp == 4) {
				resultStr += map.get(tmp * 4);
				resultNum -= tmp * 4;
			}

			// 1 * tmp 수정
			int idx = resultNum / tmp;
			for (int k = 0; k < idx; k++) {
				resultStr += map.get(tmp * 1);
				resultNum -= tmp * 1;
			}

		}
		System.out.println(resultStr);
	}
}
