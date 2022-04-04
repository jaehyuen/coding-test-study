package baekjoon.자료구조.쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int result = 0;
		int pipeCnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			//레이저를 만나면 쇠막대기 수만큼 최종값에 더해준다
			if (arr[i] == '(' && arr[i + 1] == ')') {
				result += pipeCnt;
				//i+1 값도 비교를 했기때문에 i값을 증가시킨다
				i++;
			} else if (arr[i] == '(') {
				//막대기 개수를 증가
				pipeCnt++;
			} else {
				//파이프가 끝나면 최총값을 1 더해준다
				pipeCnt--;
				result++;
			}

		}
		System.out.println(result);

	}

}
