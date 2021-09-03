package programmers.정렬.H_Index;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    citations    = {10,11,12,13};

		Solution solution = new Solution();

		assertEquals(4, solution.solution(citations));
	}

}
