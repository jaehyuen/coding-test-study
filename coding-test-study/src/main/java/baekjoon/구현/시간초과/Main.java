package baekjoon.구현.시간초과;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String S = st.nextToken();
			BigInteger N = new BigInteger(st.nextToken());
			BigInteger T = new BigInteger(st.nextToken());
			BigInteger L = new BigInteger(st.nextToken());

			boolean flag = true;

			// 시간 복잡도별로 분리
			switch (S) {
				case "O(N)":
					flag = checkCase1(N, T, L);
					break;
				case "O(N^2)":
					flag = checkCase2(N, T, L);
					break;
				case "O(N^3)":
					flag = checkCase3(N, T, L);
					break;
				case "O(2^N)":
					flag = checkCase4(N, T, L);
					break;
				case "O(N!)":
					flag = checkCase5(N, T, L);
					break;
			}

			if (flag) {
				System.out.println("May Pass.");
			} else {
				System.out.println("TLE!");
			}

		}

	}

	public static boolean checkCase1(BigInteger N, BigInteger T, BigInteger L) {
		BigInteger limit = L.multiply(BigInteger.valueOf(100000000));

		BigInteger time = N.multiply(T);

		if (time.compareTo(limit) <= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase2(BigInteger N, BigInteger T, BigInteger L) {
		BigInteger limit = L.multiply(BigInteger.valueOf(100000000));

		BigInteger time = N.pow(2).multiply(T);

		if (time.compareTo(limit) <= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase3(BigInteger N, BigInteger T, BigInteger L) {
		BigInteger limit = L.multiply(BigInteger.valueOf(100000000));

		BigInteger time = N.pow(3).multiply(T);

		if (time.compareTo(limit) <= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase4(BigInteger N, BigInteger T, BigInteger L) {
		BigInteger limit = L.multiply(BigInteger.valueOf(100000000));

		BigInteger time = BigInteger.valueOf(2);
		time = time.pow(N.intValue()).multiply(T);

		if (time.compareTo(limit) <= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase5(BigInteger N, BigInteger T, BigInteger L) {
		BigInteger limit = L.multiply(BigInteger.valueOf(100000000));

		BigInteger time = BigInteger.ONE;

		for (int i = 2; i < N.intValue(); i++) {

			time = time.multiply(BigInteger.valueOf(i));

			// 팩토리얼 진행중에 값이 초과되면 종료
			if (time.compareTo(limit) == 1) {
				return false;
			}
		}

		if (time.multiply(T).compareTo(limit) <= 0) {
			return true;
		} else {
			return false;
		}

	}
}
