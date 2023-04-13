package baekjoon.문자열.DNA_비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		char[] str = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());

		int[] cnt = new int[4];
		int[] now = new int[4];

		cnt[0] = Integer.parseInt(st.nextToken());
		cnt[1] = Integer.parseInt(st.nextToken());
		cnt[2] = Integer.parseInt(st.nextToken());
		cnt[3] = Integer.parseInt(st.nextToken());

		// 첫 P자리 문자의 조건 체크
		for (int i = 0; i < P; i++) {
			if (str[i] == 'A') {
				now[0]++;
			} else if (str[i] == 'C') {
				now[1]++;
			} else if (str[i] == 'G') {
				now[2]++;
			} else if (str[i] == 'T') {
				now[3]++;
			}
		}

		int result = check(cnt, now);

		for (int i = P; i < S; i++) {

			// 맨 뒤 문자열 추가
			if (str[i] == 'A') {
				now[0]++;
			} else if (str[i] == 'C') {
				now[1]++;
			} else if (str[i] == 'G') {
				now[2]++;
			} else if (str[i] == 'T') {
				now[3]++;
			}
			// 맨 앞 문자열 지우기
			if (str[i - P] == 'A') {
				now[0]--;
			} else if (str[i - P] == 'C') {
				now[1]--;
			} else if (str[i - P] == 'G') {
				now[2]--;
			} else if (str[i - P] == 'T') {
				now[3]--;
			}
			result += check(cnt, now);
		}
		System.out.println(result);
	}

	public static int check(int[] cnt, int[] now) {
		// 조건을 통과하면 1 아님 0 리턴
		if (cnt[0] <= now[0] && cnt[1] <= now[1] && cnt[2] <= now[2] && cnt[3] <= now[3]) {
			return 1;
		} else {
			return 0;
		}
	}

}
