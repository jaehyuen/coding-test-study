package baekjoon.그리디.수들의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		long           S   = Long.parseLong(br.readLine());

		long           sum = 0;
		long           cnt = 1;

		while (true) {
			sum += cnt;
			// 1부터 cnt까지 더한 값이 S보다 크면 cnt-1이 답
			if (sum > S) {
				System.out.println(cnt - 1);
				return;
			}
			cnt++;
		}

	}
}
