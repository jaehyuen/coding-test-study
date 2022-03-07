package baekjoon.구현.수_이어_쓰기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int result = 0;
		int tmp = 9;
		int size = (int) (Math.log10(N) + 1);

		for (int i = 1; i < size; i++) {
			result += i * tmp;
			tmp *= 10;
		}
		int last = (int) (N - Math.pow(10, size - 1) + 1) * size;
		result += last;

		System.out.println(result);
	}

}
