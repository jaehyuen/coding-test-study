package baekjoon.그리디.Byte_Coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             n   = Integer.parseInt(st.nextToken());
		long            W   = Long.parseLong(st.nextToken());

		int[]           arr = new int[n + 1];
		int             idx = -1;
		long            cnt = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {

			if (idx == -1 && arr[i] < arr[i + 1]) {

				// 구매한적이 없고 다음날보다 가격이 낮다면 구매
				// 구매 가격 인덱스 저장
				idx = i;

				// 구매 갯수
				cnt = W / arr[i];

				// 남은 돈
				W %= arr[i];

			} else if (idx != -1 && arr[i] > arr[i + 1]) {

				// 이미 구매를 햇는데 다음날 가격이 떨어진다면 판매
				W += arr[i] * cnt;

				// 구매 인덱스 초기화
				idx = -1;

			}
		}
		System.out.println(W);

	}

}
