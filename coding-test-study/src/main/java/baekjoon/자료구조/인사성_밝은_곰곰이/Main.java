package baekjoon.자료구조.인사성_밝은_곰곰이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			//누군가 입장하면 맵을 초기화
			if (str.equals("ENTER")) {
				map.clear();
			} else {
				int v = map.getOrDefault(str, -1);
				
				//처음 채팅을 하면 카운팅
				if (v == -1) {
					cnt++;
					map.put(str, 1);
				}
			}

		}

		System.out.println(cnt);
	}

}
