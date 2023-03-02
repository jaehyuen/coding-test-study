package baekjoon.이분탐색.휴게소_세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int L;

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N + 2];

		int start = 0;
		int end = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 마지막 위치 체크
		arr[N + 1] = L;

		Arrays.sort(arr);

		for (int i = 1; i <= N + 1; i++) {

			// 현재 만들어진 휴게소 거리 최대값을 구한다
			end = Math.max(arr[i] - arr[i - 1], end);
		}

		while (end > start) {
			int mid = (end + start) / 2;

			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}

	public static boolean check(int distance) {
		int cnt = 0;

		for (int i = 1; i <= N + 1; i++) {
			double tmp = arr[i] - arr[i - 1];

			// 구간마다 해당하는 간격을 최대값으로 휴게소를 추가적으로 세운다
			cnt += Math.ceil((tmp / distance)) - 1;
		}

		if (cnt <= M) {
			// 휴게소가 정상적으로 세워짐
			return true;
		} else {

			// 휴게소가 너무 많이 세워짐 = 해당 간격보다 더 큰 간격으로 휴게소를 세워야한다
			return false;
		}
	}

}
