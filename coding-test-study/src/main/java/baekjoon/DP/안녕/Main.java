package baekjoon.DP.안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] L = new int[N + 1];
		int[] J = new int[N + 1];

		int[][] dp = new int[N + 1][2];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			
			L[i] = Integer.parseInt(st1.nextToken());
			J[i] = Integer.parseInt(st2.nextToken());

		}
	    dp[1][100 -L[1]] = J[1];
	    
	 
	    for (int i = 2; i <= N; i++) {
	        dp[i][100 - L[i]] = J[i];
	        for (int j = 100; j > 0; j--) {
	            if (j + L[i] <= 100 && dp[i - 1][j + L[i]] != 0) {
	                dp[i][j] = Math.max(dp[i - 1][j + L[i]] + J[i], dp[i - 1][j]);
	            } else {
	                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
	            }
	        }
	    }
	 
	    int result = 0;
	    
	    for (int i = 100; i > 0; i--) {
	    	result = Math.max(dp[N][i], result);
	    }
	    System.out.println(result);


	}
}