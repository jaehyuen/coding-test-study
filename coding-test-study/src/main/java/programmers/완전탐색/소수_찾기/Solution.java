package programmers.완전탐색.소수_찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution {
	public int solution(String numbers) {

		// 완전 탐색(조합)으로 생성되는 숫자를 저장하는 set(중복을 피하기 위함)
		HashSet<Integer> set = new HashSet<>();

		// 조합을 하기위해 숫자를 한개씩 나눈다
		String[] arr = numbers.split("");

		// 조합을 할떄 쓰는 방문 체크 배열
		boolean[] v = new boolean[arr.length];

		find(arr, "", v, set);

		// 조합된 숫자를 리스트로 변경하여 최대값을 뽑아준다
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		int max = list.get(list.size() - 1);

		// 에라토스테네스의 체를 진행하기 위한 배열
		boolean[] isPrime = new boolean[max + 1];

		// 0, 1 은 소수가 아니므로 초기값 세팅
		isPrime[0] = true;
		isPrime[1] = true;

		// 에라토스테네스의 체 실행
		for (int i = 2; i * i <= max; i++) {
			if (isPrime[i] == false) {
				for (int j = i * i; j <= max; j += i) {
					isPrime[j] = true;
				}
			}
		}

		// 소수인 경우만 카운팅
		int cnt = 0;
		for (int i : list) {
			if (!isPrime[i])
				cnt++;
		}
		return cnt;
	}

	public void find(String[] arr, String number, boolean[] v, HashSet<Integer> set) {

		// 조합이 있으면 set에 추가
		if (!number.isEmpty())
			set.add(Integer.parseInt(number));

		// 모든 숫자를 조합햇으면 재귀종료
		if (arr.length == number.length()) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				find(arr, number + arr[i], v, set);
				v[i] = false;
			}
		}

	}
}