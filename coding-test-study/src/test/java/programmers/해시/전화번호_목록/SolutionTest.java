package programmers.해시.전화번호_목록;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	
	@Test
	void case1() {
		String[] phone_book = { "119", "97674223", "1195524421" };

		Solution solution    = new Solution();

		assertEquals(false, solution.solution( phone_book));
	}
	
	@Test
	void case2() {
		String[] phone_book = { "123","456","789"};

		Solution solution    = new Solution();

		assertEquals(true, solution.solution( phone_book));
	}

	@Test
	void case3() {
		String[] phone_book = { "12","123","1235","567","88" };

		Solution solution    = new Solution();

		assertEquals(false, solution.solution( phone_book));
	}

}
