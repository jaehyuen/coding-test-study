package baekjoon.그리디.폴리오미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String         str = br.readLine();
		
		//A로 변경가능한거 전부 변경
		str = str.replaceAll("XXXX", "AAAA");
		
		//B로 변경가능한거 전부 변경
		str = str.replaceAll("XX", "BB");
		
		//변경 안된게 잇는지 확인
		for (char c : str.toCharArray()) {
			if (c == 'X') {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(str);
	}

}
