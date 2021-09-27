package baekjoon.자료구조.ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}

		Arrays.sort(arr);

		int wait = 0;
		int result = 0;
		for (int ar : arr) {
			result += ar;
			result += wait;
			wait += ar;

		}
		System.out.println(result);

	}

}