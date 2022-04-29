package programmers.그래프.여행경로;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {
		String[][] tickets  = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };

		Solution   solution = new Solution();

		assertEquals(new String[] { "ICN", "JFK", "HND", "IAD" }, solution.solution(tickets));
	}

	@Test
	void case2() {
		String[][] tickets  = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

		Solution   solution = new Solution();

		assertEquals(new String[] { "ICN", "ATL", "ICN", "SFO", "ATL", "SFO" }, solution.solution(tickets));
	}
	
	@Test
	void case3() {
		String[][] tickets  = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" } };

		Solution   solution = new Solution();

		assertEquals(new String[] { "ICN", "ATL", "ICN", "SFO", "ATL", "SFO" }, solution.solution(tickets));
	}


}
