# 마법사 상어와 비바라기

### 문제

마법사 상어는 파이어볼, 토네이도, 파이어스톰, 물복사버그 마법을 할 수 있다. 오늘 새로 배운 마법은 비바라기이다. 비바라기를 시전하면 하늘에 비구름을 만들 수 있다. 오늘은 비바라기를 크기가 N×N인 격자에서 연습하려고 한다. 격자의 각 칸에는 바구니가 하나 있고, 바구니는 칸 전체를 차지한다. 바구니에 저장할 수 있는 물의 양에는 제한이 없다. (r, c)는 격자의 r행 c열에 있는 바구니를 의미하고, A[r][c]는 (r, c)에 있는 바구니에 저장되어 있는 물의 양을 의미한다.

격자의 가장 왼쪽 윗 칸은 (1, 1)이고, 가장 오른쪽 아랫 칸은 (N, N)이다. 마법사 상어는 연습을 위해 1번 행과 N번 행을 연결했고, 1번 열과 N번 열도 연결했다. 즉, N번 행의 아래에는 1번 행이, 1번 행의 위에는 N번 행이 있고, 1번 열의 왼쪽에는 N번 열이, N번 열의 오른쪽에는 1번 열이 있다.

비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다. 구름은 칸 전체를 차지한다. 이제 구름에 이동을 M번 명령하려고 한다. i번째 이동 명령은 방향 di과 거리 si로 이루어져 있다. 방향은 총 8개의 방향이 있으며, 8개의 정수로 표현한다. 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 이다. 이동을 명령하면 다음이 순서대로 진행된다.

1. 모든 구름이 di 방향으로 si칸 이동한다.
2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
3. 구름이 모두 사라진다.
4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.

   - 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
   - 예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.

5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
   M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자.

### 입력

첫째 줄에 N, M이 주어진다.

둘째 줄부터 N개의 줄에는 N개의 정수가 주어진다. r번째 행의 c번째 정수는 A[r][c]를 의미한다.

다음 M개의 줄에는 이동의 정보 di, si가 순서대로 한 줄에 하나씩 주어진다.

### 출력

첫째 줄에 M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 출력한다.

### 제한

- 2 ≤ N ≤ 50
- 1 ≤ M ≤ 100
- 0 ≤ A[r][c] ≤ 100
- 1 ≤ di ≤ 8
- 1 ≤ si ≤ 50

### 예제 입력 1

```
5 4
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3
3 4
8 1
4 8
```

### 예제 출력 1

```
77
```

    <p>구름이 있는 칸은 빨간색으로 표시했고, 물이 증가한 칸은 초록색으로 표시했다.</p>

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>2</td>
		</tr>
		<tr>
			<td>2</td>
			<td>3</td>
			<td>2</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td>4</td>
			<td>3</td>
			<td>2</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td class="bg-red">1</td>
			<td class="bg-red">0</td>
			<td>2</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td class="bg-red">8</td>
			<td class="bg-red">8</td>
			<td>2</td>
			<td>1</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<p>첫 번째 이동은 구름이 1번 방향(&larr;)으로 3칸 이동해야 한다. 구름이 이동한 후는 다음과 같다.</p>

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>2</td>
		</tr>
		<tr>
			<td>2</td>
			<td>3</td>
			<td>2</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td>4</td>
			<td>3</td>
			<td>2</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td>1</td>
			<td>0</td>
			<td class="bg-red">2</td>
			<td class="bg-red">9</td>
			<td>0</td>
		</tr>
		<tr>
			<td>8</td>
			<td>8</td>
			<td class="bg-red">2</td>
			<td class="bg-red">1</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<p>구름이 있는 칸에 비가 1씩 내리고, 구름은 사라진다.</p>

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>2</td>
		</tr>
		<tr>
			<td>2</td>
			<td>3</td>
			<td>2</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td>4</td>
			<td>3</td>
			<td>2</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td>1</td>
			<td>0</td>
			<td class="bg-green">3</td>
			<td class="bg-green">10</td>
			<td>0</td>
		</tr>
		<tr>
			<td>8</td>
			<td>8</td>
			<td class="bg-green">3</td>
			<td class="bg-green">2</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<p>(4, 3)은 대각선 4개의 방향 모두에 물이 있다. 따라서, 물의 양이 4 증가해 7이 된다. (4, 4)는 대각선 2개의 방향(↖,&nbsp;↙)에 물이 있다. 물의 양은 2 증가하고, 12가 된다. (5, 3)은 대각선으로 거리가 1인 칸이 2개(↖,&nbsp;↗)있고, 이 중에서 1개(↗)만 물이 있다. 따라서, 물의 양은 3에서 4로 변한다. (5, 4)도 방향 1개(↖)만 물이 있기 때문에, 물의 양이 3이 된다.</p>

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>2</td>
		</tr>
		<tr>
			<td>2</td>
			<td>3</td>
			<td>2</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td>4</td>
			<td>3</td>
			<td>2</td>
			<td>9</td>
			<td>0</td>
		</tr>
		<tr>
			<td>1</td>
			<td>0</td>
			<td class="bg-green">7</td>
			<td class="bg-green">12</td>
			<td>0</td>
		</tr>
		<tr>
			<td>8</td>
			<td>8</td>
			<td class="bg-green">4</td>
			<td class="bg-green">3</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<p>이제 구름이 있었던 칸을 제외한 나머지 칸 중에서 물의 양이 2 이상인 칸에 구름이 생긴다. 구름이 생기면 물의 양이 2만큼 줄어든다.</p>

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td class="bg-red">0</td>
		</tr>
		<tr>
			<td class="bg-red">0</td>
			<td class="bg-red">1</td>
			<td class="bg-red">0</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td class="bg-red">2</td>
			<td class="bg-red">1</td>
			<td class="bg-red">0</td>
			<td class="bg-red">7</td>
			<td>0</td>
		</tr>
		<tr>
			<td>1</td>
			<td>0</td>
			<td>7</td>
			<td>12</td>
			<td>0</td>
		</tr>
		<tr>
			<td class="bg-red">6</td>
			<td class="bg-red">6</td>
			<td>4</td>
			<td>3</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<p>두 번째 이동이 끝난 후의 상태는 다음과 같다.</p>

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>2</td>
			<td>1</td>
			<td>1</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td>5</td>
			<td>4</td>
			<td>5</td>
			<td class="bg-red">5</td>
			<td>0</td>
		</tr>
		<tr>
			<td>4</td>
			<td>5</td>
			<td>12</td>
			<td>15</td>
			<td>0</td>
		</tr>
		<tr>
			<td class="bg-red">4</td>
			<td class="bg-red">4</td>
			<td class="bg-red">2</td>
			<td class="bg-red">1</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

### 예제 입력 2

```
5 8
0 0 1 0 2
2 3 2 1 0
0 0 2 0 0
1 0 2 0 0
0 0 2 1 0
1 9
2 8
3 7
4 6
5 5
6 4
7 3
8 2
```

### 예제 출력 2

```
41
```

<table class="table table-bordered table-center-30 table-21610">
    <tbody>
    	<tr>
    		<td>2</td>
    		<td class="bg-red">1</td>
    		<td>1</td>
    		<td>0</td>
    		<td>0</td>
    	</tr>
    	<tr>
    		<td class="bg-red">1</td>
    		<td class="bg-red">0</td>
    		<td class="bg-red">3</td>
    		<td class="bg-red">7</td>
    		<td>1</td>
    	</tr>
    	<tr>
    		<td>1</td>
    		<td class="bg-red">1</td>
    		<td class="bg-red">9</td>
    		<td>0</td>
    		<td class="bg-red">0</td>
    	</tr>
    	<tr>
    		<td>0</td>
    		<td>1</td>
    		<td class="bg-red">4</td>
    		<td>0</td>
    		<td>2</td>
    	</tr>
    	<tr>
    		<td>2</td>
    		<td class="bg-red">1</td>
    		<td>2</td>
    		<td>1</td>
    		<td>1</td>
    	</tr>
    </tbody>
</table>

### 예제 입력 3

```
5 8
100 100 100 100 100
100 100 100 100 100
100 100 100 100 100
100 100 100 100 100
100 100 100 100 100
8 1
7 1
6 1
5 1
4 1
3 1
2 1
1 1
```

### 예제 출력 3

```
2657
```

<table class="table table-bordered table-center-30 table-21610">
	<tbody>
		<tr>
			<td>100</td>
			<td>104</td>
			<td>104</td>
			<td>104</td>
			<td>100</td>
		</tr>
		<tr>
			<td>104</td>
			<td>112</td>
			<td>112</td>
			<td>119</td>
			<td>99</td>
		</tr>
		<tr>
			<td>109</td>
			<td>112</td>
			<td>105</td>
			<td>112</td>
			<td>104</td>
		</tr>
		<tr>
			<td class="bg-red">99</td>
			<td class="bg-red">112</td>
			<td>119</td>
			<td>112</td>
			<td>104</td>
		</tr>
		<tr>
			<td class="bg-red">100</td>
			<td class="bg-red">104</td>
			<td>104</td>
			<td>99</td>
			<td>104</td>
		</tr>
	</tbody>
</table>
