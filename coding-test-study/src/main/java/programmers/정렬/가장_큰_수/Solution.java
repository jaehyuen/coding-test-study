package programmers.정렬.가장_큰_수;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public String solution(int[] numbers) {
		String[] numStr = IntStream.of(numbers)
			.mapToObj(String::valueOf)
			.toArray(String[]::new);

		Arrays.sort(numStr, (o1, o2) -> {
			return (o2 + o1).compareTo((o1 + o2));
		});

		String answer = Arrays.stream(numStr)
			.collect(Collectors.joining());
		return numStr[0].equals("0") ? "0" : answer;
	}

}
