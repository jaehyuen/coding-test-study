package baekjoon.정렬.소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		//배열의 크기 -1 만큼 반복
		for (int i = 1; i < arr.length; i++) {
			
			//한번 반복할때마다 앞자리를 하나씩 결정
			for (int j = arr.length - 1; j >= i; j--) {

				// 현재보다 앞자리가 작으면 스왑
				if (arr[j] > arr[j - 1]) {
					char tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}

			}

		}

		for (char a : arr) {
			System.out.print(a);
		}
	}

}
