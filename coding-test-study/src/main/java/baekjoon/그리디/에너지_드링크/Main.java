package baekjoon.그리디.에너지_드링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());

		float[]         arr = new float[N];
		StringTokenizer st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Float.parseFloat(st.nextToken());
		}

		// 정렬
		Arrays.sort(arr);

		// 제일 양이 많은곳에 추가한다
		for (int i = 0; i < N - 1; i++) {
			arr[N - 1] += arr[i] / 2;
		}

		System.out.println(arr[N - 1]);
	}

}
