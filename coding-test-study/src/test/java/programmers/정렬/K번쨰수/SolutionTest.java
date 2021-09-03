package programmers.정렬.K번쨰수;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    array    = { 10, 11, 12, 13 };
		int[][]  commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		Solution solution = new Solution();

		assertEquals(4, solution.solution(array, commands));
	}

}
