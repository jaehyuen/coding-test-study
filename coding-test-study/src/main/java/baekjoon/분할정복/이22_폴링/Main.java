package baekjoon.분할정복.이22_폴링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            N  = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		// 초기값 세팅
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 분할정복 시작
		find(N);

	}

	public static void find(int size) {

		int cnt = 0;

		// 반복하며 2x2 사각형 시작점을 찾는다
		for (int i = 0; i < size; i += 2) {
			for (int j = 0; j < size; j += 2) {

				// 찾은 시작점에서 4칸을 배열로 선언 및 정렬후 2번쨰로 큰값을 찾는다
				int[] tmp = { arr[i][j], arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1] };
				Arrays.sort(tmp);

				// 찾은 값을 배열에 다시 넣는다
				arr[cnt / (size / 2)][cnt % (size / 2)] = tmp[2];
				cnt++;

			}
		}

		// 가로, 세로 크기가 2이상이면 다시 풀링을 하고 아니면 마지막값을 출력
		if (size > 2) {
			find(size / 2);
		} else {
			System.out.println(arr[0][0]);
		}

	}
}
