package baekjoon.이분탐색.숫자_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int   N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		N   = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 상근이가 가지고있는 카드를 입력 받는다
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 카드를 정렬한다
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			// 카드를 가지고있는지 이분탐색 진행
			sb.append(find(Integer.parseInt(st.nextToken())) + " ");
		}
		System.out.println(sb.toString());
	}

	public static int find(int idx) {

		int start = 0;
		int end   = N - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] > idx) {
				end = mid - 1;
			} else if (arr[mid] < idx) {
				start = mid + 1;
			} else {
				return 1;
			}
		}

		// 탐색 결과 같은값이 없으므로 0 리턴
		return 0;
	}

}
