package programmers.정렬.가장_큰_수;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    citations    = {10, 101};

		Solution solution = new Solution();

		assertEquals(4, solution.solution(citations));
	}

}
