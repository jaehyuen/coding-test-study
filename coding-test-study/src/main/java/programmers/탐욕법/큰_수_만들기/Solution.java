package programmers.탐욕법.큰_수_만들기;

class Solution {
	public String solution(String number, int k) {

		int           idx    = number.length() - k;

		StringBuilder result = new StringBuilder();

		while (true) {
			if (idx <= 0) {
				break;
			}

			String str1 = number.substring(0, number.length() - idx + 1);

			idx--;

			String max = new Character((char) str1.chars()
				.max()
				.getAsInt()).toString();

			number = number.substring(number.indexOf(max) + 1);

			result.append(max);
		}

		return result.toString();
	}
}