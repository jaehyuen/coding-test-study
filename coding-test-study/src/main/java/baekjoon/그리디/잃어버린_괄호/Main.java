package baekjoon.±×¸®µð.ÀÒ¾î¹ö¸°_°ýÈ£;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String[] arr = str.split("\\-");

		int result = 0;
		for (int i = 0; i < arr.length; i++) {

			String[] arr2 = arr[i].split("\\+");
			int tmp = 0;

			for (int j = 0; j < arr2.length; j++) {
				tmp += Integer.parseInt(arr2[j]);
			}

			if (i == 0) {
				result = tmp;
			} else {
				result -= tmp;
			}
		}
		System.out.println(result);

	}

}
