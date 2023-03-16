package baekjoon.구현.원판_돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int T;

    public static int[][] arr;

    public static int[] xArr = { 1, -1, 0, 0 };
    public static int[] yArr = { 0, 0, 1, -1 };

    public static int sum = 0;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 총합
                sum += arr[i][j];

            }

        }

        cnt = N * M;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // x 배수번째 원판을 고른다
            for (int j = x; j <= N; j += x) {

                // 횟수만큼 회전
                for (int q = 0; q < k; q++) {
                    spin(j - 1, d);
                }

            }

            delete();
        }
        System.out.println(sum);
    }

    public static int boundaryCheck(int y) {

        // 좌우 바운더리 체크 함수
        if (y < 0) {
            return M - 1;
        } else {
            return y % M;
        }

    }

    public static void delete() {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 이미 제거된곳이면 지나감
                if (arr[i][j] == 0) {
                    continue;
                }
                // 인접한 4곳 찾기
                for (int a = 0; a < 4; a++) {

                    int x = i + xArr[a];
                    int y = boundaryCheck(j + yArr[a]);

                    // 원판 범위 체크
                    if (x < 0 || x >= N) {
                        continue;
                    }

                    if (arr[x][y] == arr[i][j]) {

                        // 제거 대상 등록
                        set.add(x * M + y);
                        set.add(i * M + j);
                    }

                }

            }
        }

        if (set.isEmpty()) {

            // 평균 계산
            double avg = sum / (double) cnt;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    // 이미 제거된곳이면 지나감
                    if (arr[i][j] == 0) {
                        continue;
                    }

                    if (arr[i][j] > avg) {
                        arr[i][j]--;
                        sum--;
                    } else if (arr[i][j] < avg) {
                        arr[i][j]++;
                        sum++;
                    }
                }
            }
        } else {
            for (int i : set) {
                int x = i / M;
                int y = i % M;

                // 합계에서 빼줌
                sum -= arr[x][y];
                arr[x][y] = 0;

                cnt--;
            }
        }

    }

    public static void spin(int idx, int dir) {
        if (dir == 0) {
            // 시계방향 회전
            int prev = arr[idx][0];

            for (int i = 1; i < M; i++) {
                int tmp = arr[idx][i];
                arr[idx][i] = prev;
                prev = tmp;
            }
            arr[idx][0] = prev;

        } else {
            // 반시계방향 회전
            int prev = arr[idx][M - 1];

            for (int i = M - 2; i >= 0; i--) {
                int tmp = arr[idx][i];
                arr[idx][i] = prev;
                prev = tmp;
            }
            arr[idx][M - 1] = prev;
        }
    }
}
