package programmers.탐욕법.구명보트;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    people   = { 70, 50, 80, 50 };

		Solution solution = new Solution();

		assertEquals(3, solution.solution(people, 100));
	}

	@Test
	void case2() {

		int[]    people   = { 40, 40, 80};

		Solution solution = new Solution();

		assertEquals(2, solution.solution(people, 160));
	}

}
