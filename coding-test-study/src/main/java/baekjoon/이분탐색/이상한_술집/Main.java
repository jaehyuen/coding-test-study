package baekjoon.이분탐색.이상한_술집;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		long start = 0;
		long end = Integer.MAX_VALUE;;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		while (end > start) {
			long mid = (end + start) / 2;

			int cnt = 0;

			for (int i : arr) {
				cnt += i / mid;
			}


			if (cnt >= K) {
				// 해당 용량으로 나눠줄 수 있다면 현재 용량이 이분탐색 시작지점
				start = mid + 1;

			} else {
				end = mid;

			}
		}
		System.out.println(start - 1);
	}

}
