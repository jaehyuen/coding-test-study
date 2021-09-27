package baekjoon.구현.그룹_단어_체커;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = Integer.parseInt(s.nextLine());
		int[] arr = new int[26];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			
			String str = s.nextLine();
			
			int index = 100;
			int lastIndex = 100;
			result++;
			
			for (char a : str.toCharArray()) {
				index = a - 97;
				if (arr[index] != 0 && index != lastIndex) {
					result--;
					break;
				}
				arr[index] = 1;
				lastIndex = a - 97;
			}
			Arrays.fill(arr, 0);
			//arr

		}

		System.out.println(result < 0 ? 0 : result);

	}

}
