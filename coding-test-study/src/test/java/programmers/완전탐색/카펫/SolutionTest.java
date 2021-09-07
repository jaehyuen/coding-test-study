package programmers.완전탐색.카펫;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		Solution solution = new Solution();

		assertEquals(4, solution.solution(10, 2));
	}

	@Test
	void case2() {

		Solution solution = new Solution();

		assertEquals(4, solution.solution(8, 1));
	}

	@Test
	void case3() {

		Solution solution = new Solution();

		assertEquals(4, solution.solution(24, 24));
	}

}
