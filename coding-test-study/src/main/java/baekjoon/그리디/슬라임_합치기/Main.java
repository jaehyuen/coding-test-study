package baekjoon.그리디.슬라임_합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		int             N      = Integer.parseInt(br.readLine());

		StringTokenizer st     = new StringTokenizer(br.readLine());
		int             tmp1   = 0;
		int             tmp2   = 0;
		int             result = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				tmp1 = Integer.parseInt(st.nextToken());
			} else {
				tmp2    = Integer.parseInt(st.nextToken());
				result += tmp1 * tmp2;
				tmp1    = tmp1 + tmp2;
			}
		}
		System.out.println(result);

	}
}
