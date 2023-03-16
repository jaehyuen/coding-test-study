# 원판 돌리기

### 문제

반지름이 1, 2, ..., N인 원판이 크기가 작아지는 순으로 바닥에 놓여있고, 원판의 중심은 모두 같다. 원판의 반지름이 i이면, 그 원판을 i번째 원판이라고 한다. 각각의 원판에는 M개의 정수가 적혀있고, i번째 원판에 적힌 j번째 수의 위치는 (i, j)로 표현한다. 수의 위치는 다음을 만족한다.

- (i, 1)은 (i, 2), (i, M)과 인접하다.
- (i, M)은 (i, M-1), (i, 1)과 인접하다.
- (i, j)는 (i, j-1), (i, j+1)과 인접하다. (2 ≤ j ≤ M-1)
- (1, j)는 (2, j)와 인접하다.
- (N, j)는 (N-1, j)와 인접하다.
- (i, j)는 (i-1, j), (i+1, j)와 인접하다. (2 ≤ i ≤ N-1)

아래 그림은 N = 3, M = 4인 경우이다.

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/5968435b-a1af-4e2a-a612-baff989f44b2/-/preview/" style="width: 300px; height: 295px;" /></p>

원판의 회전은 독립적으로 이루어진다. 2번 원판을 회전했을 때, 나머지 원판은 회전하지 않는다. 원판을 회전시킬 때는 수의 위치를 기준으로 하며, 회전시킨 후의 수의 위치는 회전시키기 전과 일치해야 한다.

다음 그림은 원판을 회전시킨 예시이다.

<table class="table table-bordered" style="width:100%;">
	<tbody>
		<tr>
			<td style="width: 33%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/977a4e67-5aa7-40d4-92ee-5f59ac75aadb/-/preview/" style="width: 300px; height: 295px;" /></td>
			<td style="width: 34%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/f2c1e70b-0a84-46c3-b38d-f7395219b00a/-/preview/" style="width: 300px; height: 295px;" /></td>
			<td style="width: 33%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/39d57771-6162-49f5-97b7-0d9fd8911222/-/preview/" style="width: 300px; height: 295px;" /></td>
		</tr>
		<tr>
			<td style="width: 33%; text-align: center;">1번 원판을 시계 방향으로 1칸 회전</td>
			<td style="width: 34%; text-align: center;">2, 3번 원판을 반시계 방향으로 3칸 회전</td>
			<td style="width: 33%; text-align: center;">1, 3번 원판을 시계 방향으로 2칸 회전</td>
		</tr>
	</tbody>
</table>

1번 원판을 시계 방향으로 1칸 회전 2, 3번 원판을 반시계 방향으로 3칸 회전 1, 3번 원판을 시계 방향으로 2칸 회전
원판을 아래와 같은 방법으로 총 T번 회전시키려고 한다. 원판의 회전 방법은 미리 정해져 있고, i번째 회전할때 사용하는 변수는 xi, di, ki이다.

번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
원판에 수가 남아 있으면, 인접하면서 수가 같은 것을 모두 찾는다.
그러한 수가 있는 경우에는 원판에서 인접하면서 같은 수를 모두 지운다.
없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
원판을 T번 회전시킨 후 원판에 적힌 수의 합을 구해보자.

### 입력

첫째 줄에 N, M, T이 주어진다.

둘째 줄부터 N개의 줄에 원판에 적힌 수가 주어진다. i번째 줄의 j번째 수는 (i, j)에 적힌 수를 의미한다.

다음 T개의 줄에 xi, di, ki가 주어진다.

### 출력

원판을 T번 회전시킨 후 원판에 적힌 수의 합을 출력한다.

### 제한

- 2 ≤ N, M ≤ 50
- 1 ≤ T ≤ 50
- 1 ≤ 원판에 적힌 수 ≤ 1,000
- 2 ≤ xi ≤ N
- 0 ≤ di ≤ 1
- 1 ≤ ki < M

### 예제 입력 1

```
4 4 1
1 1 2 3
5 2 4 2
3 1 3 5
2 1 3 2
2 0 1
```

### 예제 출력 1

```
30
```

원판의 초기 상태는 다음과 같다.

<table class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/6374fb88-a46d-40b7-b692-dbc9d2abe75f/-/preview/" style="width: 400px; height: 397px;" /></td>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/196cd4ac-1c4e-4cd3-b714-0672e115aa69/-/preview/" style="width: 400px; height: 397px;" /></td>
		</tr>
		<tr>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>x<sub>1</sub> = 2, d<sub>1</sub> = 0, k<sub>1</sub> = 1</p>
			<p>2번, 4번 원판을 시계 방향으로 1칸 돌린 후</p>
			</td>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>인접하면서 수가 같은 것을 모두 지운 후</p>
			</td>
		</tr>
	</tbody>
</table>

### 예제 입력 2

```
4 4 2
1 1 2 3
5 2 4 2
3 1 3 5
2 1 3 2
2 0 1
3 1 3
```

### 예제 출력 2

```
22
```

예제 1에서 이어진다.

<table class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/8dbd0c76-cfac-4852-bbb1-77763051e26b/-/preview/" style="width: 400px; height: 397px;" /></td>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/955577a2-d3ec-413d-8341-59dbf1bf23c3/-/preview/" style="width: 400px; height: 397px;" /></td>
		</tr>
		<tr>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>x<sub>2</sub> = 3, d<sub>2</sub> = 1, k<sub>2</sub> = 3</p>
			<p>3번 원판을 반시계 방향으로 3칸 돌린 후</p>
			</td>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>인접하면서 수가 같은 것을 모두 지운 후</p>
			</td>
		</tr>
	</tbody>
</table>

### 예제 입력 3

```
4 4 3
1 1 2 3
5 2 4 2
3 1 3 5
2 1 3 2
2 0 1
3 1 3
2 0 2
```

### 예제 출력 3

```
22
```

예제 2에서 이어진다.

<table class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/74c7928f-1eaa-45bd-a2a6-f762705ef0a9/-/preview/" style="width: 400px; height: 397px;" /></td>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/5a8c5371-1fca-45b0-909b-4f62b8fe058e/-/preview/" style="width: 400px; height: 397px;" /></td>
		</tr>
		<tr>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>x<sub>3</sub> = 2, d<sub>3</sub> = 0, k<sub>3</sub> = 2</p>
			<p>2, 4번 원판을 시계 방향으로 2칸 돌린 후</p>
			</td>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>인접하면서 수가 같은 것이 없다.</p>
			<p>따라서, 평균 22/6 보다 작은 수는 +1, 큰 수는 -1 했다.</p>
			</td>
		</tr>
	</tbody>
</table>

### 예제 입력 4

```
4 4 4
1 1 2 3
5 2 4 2
3 1 3 5
2 1 3 2
2 0 1
3 1 3
2 0 2
3 1 1
```

### 예제 출력 4

```
0
```

예제 3에서 이어진다.

<table class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/9eaff649-6149-4e82-958d-dd32c75cf93c/-/preview/" style="width: 400px; height: 397px;" /></td>
			<td style="width: 50%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/84bae2b9-22c6-4da5-b9b2-c2a85e7af707/-/preview/" style="width: 400px; height: 397px;" /></td>
		</tr>
		<tr>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>x<sub>4</sub> = 3, d<sub>4</sub> = 1, k<sub>4</sub> = 1</p>
			<p>3번 원판을 반시계 방향으로 1칸 돌린 후</p>
			</td>
			<td style="width: 50%; text-align: center; vertical-align: middle;">
			<p>인접하면서 수가 같은 것을 모두 지운 후</p>
			</td>
		</tr>
	</tbody>
</table>

### 예제 입력 5

```
4 6 3
1 2 3 4 5 6
2 3 4 5 6 7
3 4 5 6 7 8
4 5 6 7 8 9
2 1 4
3 0 1
2 1 2
```

### 예제 출력 5

```
26
```
