package baekjoon.이분탐색.입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int M;

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		long start = 0;
		long end = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			end = Math.min(end, arr[i]);
		}

		// 가장 빨리 끝나는 심사대에서 모두가 심사 받는 경우 까지 이분 탐색
		end *= M;

		while (end > start) {
			long mid = ((end + start) / 2);

			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}
		System.out.println(start);
	}

	public static boolean check(long time) {
		long cnt = 0;

		// 현재 시간만큼 해당 심사대에서 심사가능한 사람수 카운팅
		for (int i : arr) {
			cnt += time / i;
		}

		// 해당 시간안에 친구들을 전부 심사 가능여부 리턴
		if (cnt >= M) {
			return true;
		} else {
			return false;
		}
	}

}
