package baekjoon.구현.비밀번호_발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb  = new StringBuilder();
		char[]         arr = { 'a', 'e', 'i', 'o', 'u' };

		while (true) {

			String tmp = br.readLine();

			// end 가 입력되면 종료
			if (tmp.equals("end")) {
				System.out.println(sb.toString());
				return;
			}

			boolean flag = false;

			// 모음 체크
			for (int i = 0; i < arr.length; i++) {
				if (tmp.contains(Character.toString(arr[i]))) {
					flag = true;
					break;
				}

			}

			if (flag) {
				char[]  tmpArr = tmp.toCharArray();
				int     cnt    = 1;
				boolean flag1  = false;
				flag = true;

				// 첫글자 모음 체크
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == tmpArr[0]) {
						flag1 = true;
						break;
					}

				}

				for (int i = 1; i < tmpArr.length; i++) {

					// 3번 조건 확인
					if (tmpArr[i] != 'e' && tmpArr[i] != 'o' && tmpArr[i] == tmpArr[i - 1]) {
						sb.append("<");
						sb.append(tmp);
						sb.append(">");
						sb.append(" is not acceptable.\n");
						flag = false;
						break;
					} else {
						boolean flag2 = false;
						// 모음 체크
						for (int j = 0; j < arr.length; j++) {
							if (arr[j] == tmpArr[i]) {
								flag2 = true;
								break;
							}

						}

						// 자음 모음 카운팅
						if (flag1 == flag2) {
							cnt++;
						} else {
							cnt   = 1;
							flag1 = !flag1;
						}

						// 2번째 조건 확인
						if (cnt > 2) {
							sb.append("<");
							sb.append(tmp);
							sb.append(">");
							sb.append(" is not acceptable.\n");
							flag = false;
							break;
						}
					}

				}

				if (flag) {
					sb.append("<");
					sb.append(tmp);
					sb.append(">");
					sb.append(" is acceptable.\n");
				}
			} else {
				sb.append("<");
				sb.append(tmp);
				sb.append(">");
				sb.append(" is not acceptable.\n");
			}

		}
	}
}
