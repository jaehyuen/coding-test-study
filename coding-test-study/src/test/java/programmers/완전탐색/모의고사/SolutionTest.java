package programmers.완전탐색.모의고사;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    answers    = {1,2,3,4,5};

		Solution solution = new Solution();

		assertEquals(4, solution.solution(answers));
	}
	
	@Test
	void case2() {

		int[]    answers    = {1,3,2,4,2};

		Solution solution = new Solution();

		assertEquals(4, solution.solution(answers));
	}

}
