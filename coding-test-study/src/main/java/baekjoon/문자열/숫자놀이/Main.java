package baekjoon.문자열.숫자놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		HashMap<Character, String> map    = new HashMap<Character, String>();
		HashMap<String, Integer>   result = new HashMap<>();
		// 숫자 영어 맵핑
		map.put('0', "zero");
		map.put('1', "one");
		map.put('2', "two");
		map.put('3', "three");
		map.put('4', "four");
		map.put('5', "five");
		map.put('6', "six");
		map.put('7', "seven");
		map.put('8', "eight");
		map.put('9', "nine");

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             M   = Integer.parseInt(st.nextToken());
		int             N   = Integer.parseInt(st.nextToken());

		// 결과 저장할 배열
		String[]        arr = new String[N - M + 1];
		int             j   = 0;

		for (int i = M; i <= N; i++) {
			String tmp = "";

			// 숫자를 char arr로 변경하여 스트링으로 컨버팅
			for (char c : String.valueOf(i)
				.toCharArray()) {
				tmp += map.get(c) + " ";
			}
			arr[j] = tmp;
			result.put(tmp, i);
			j++;
		}

		// 정렬
		Arrays.sort(arr);

		// 10개 마다 줄바꿈 해서 출력
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(result.get(arr[i]) + " ");

		}
	}

}
