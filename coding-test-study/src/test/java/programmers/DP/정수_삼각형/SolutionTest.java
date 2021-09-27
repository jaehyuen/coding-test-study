package programmers.DP.정수_삼각형;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[][]  triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

		Solution solution = new Solution();

		assertEquals(30, solution.solution(triangle));
	}

}
