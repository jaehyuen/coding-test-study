package programmers.완전탐색.소수_찾기;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		String numbers = "17";

		Solution solution = new Solution();

		assertEquals(3, solution.solution(numbers));
	}

	@Test
	void case2() {

		String numbers = "011";

		Solution solution = new Solution();

		assertEquals(2, solution.solution(numbers));
	}

}
