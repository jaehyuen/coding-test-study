package baekjoon.이분탐색.기타_레슨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int M;

	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		int start = 0;
		int end = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

			// 이분 탐색 마지막 위치는 강의 시간을 모두 더한 시간
			end += arr[i];

			// 이분 탐색 시작 위치는 가장 긴 강의시간 부터 시작
			start = Math.max(start, arr[i]);
		}
		// System.out.println(check(9));

		while (end > start) {
			int mid = (start + end) / 2;

			// 함수 실행 결과가 블루레이 갯수보다 작으면 블루레이를 못만든다는 의미이다
			// 그렇기에 블루레이 크기를 키운다
			if (check(mid) > M) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		System.out.println(start);

	}

	public static int check(int idx) {
		int cnt = 1;
		int sum = 0;

		for (int i = 0; i < N; i++) {

			// 블루레이 크기가 넘어가면
			if (sum + arr[i] > idx) {

				cnt++;
				sum = arr[i];
			} else {
				sum += arr[i];
			}

		}
		return cnt;
	}

}
