package programmers.정렬.K번쨰수;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public int[] solution(int[] array, int[][] commands) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < commands.length; i++) {
			int[] arr2 = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(arr2);
			System.out.println(arr2[commands[i][2] - 1]);
			result.add(arr2[commands[i][2] - 1]);
		}

		return result.stream()
				.mapToInt(i -> i)
				.toArray();
	}

}
