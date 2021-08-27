package programmers.해시.전화번호_목록;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public boolean solution(String[] phone_book) {

		List<String> phone_bookList = new ArrayList<String>(Arrays.asList(phone_book));
		phone_bookList.sort(null);

		if (phone_bookList.get(1).startsWith(phone_bookList.get(0))) {
			return false;
		}
		for (int i = 1; i < phone_bookList.size(); i++) {
			if (phone_bookList.get(i)
				.startsWith(phone_bookList.get(i - 1))) {
				return false;
			}
		}

		return true;
	}
}
