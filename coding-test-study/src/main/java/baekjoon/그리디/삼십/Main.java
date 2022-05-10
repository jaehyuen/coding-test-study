package baekjoon.그리디.삼십;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String         N   = br.readLine();

		int[]          arr = new int[N.length()];

		// 자릿수를 다 더해서 3의 배수가 나와야 한다
		int            sum = 0;

		for (int i = 0; i < N.length(); i++) {
			arr[i]  = Character.getNumericValue(N.charAt(i));
			sum    += arr[i];
		}

		Arrays.sort(arr);

		// 3의 배수가 만들어졋으면 정렬한대로 뽑아주면 된다
		if (arr[0] == 0 && sum % 3 == 0) {
			for (int i = arr.length - 1; i >= 0; i--) {
				System.out.print(arr[i]);
			}

		} else {
			System.out.println(-1);

		}

	}

}
