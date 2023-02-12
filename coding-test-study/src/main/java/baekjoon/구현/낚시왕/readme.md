# 낚시왕
 
### 문제

낚시왕이 상어 낚시를 하는 곳은 크기가 R×C인 격자판으로 나타낼 수 있다. 격자판의 각 칸은 (r, c)로 나타낼 수 있다. r은 행, c는 열이고, (R, C)는 아래 그림에서 가장 오른쪽 아래에 있는 칸이다. 칸에는 상어가 최대 한 마리 들어있을 수 있다. 상어는 크기와 속도를 가지고 있다.

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/85c2ccad-e4b8-4397-9bd6-0ec73b0f44f8/-/preview/" style="width: 506px; height: 350px;" /></p>

낚시왕은 처음에 1번 열의 한 칸 왼쪽에 있다. 다음은 1초 동안 일어나는 일이며, 아래 적힌 순서대로 일어난다. 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.

1. 낚시왕이 오른쪽으로 한 칸 이동한다.
2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
3. 상어가 이동한다.

상어는 입력으로 주어진 속도로 이동하고, 속도의 단위는 칸/초이다. 상어가 이동하려고 하는 칸이 격자판의 경계를 넘는 경우에는 방향을 반대로 바꿔서 속력을 유지한채로 이동한다.

왼쪽 그림의 상태에서 1초가 지나면 오른쪽 상태가 된다. 상어가 보고 있는 방향이 속도의 방향, 왼쪽 아래에 적힌 정수는 속력이다. 왼쪽 위에 상어를 구분하기 위해 문자를 적었다.

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/d03be3c0-057d-47f7-9808-202ae36a3da3/-/preview/" style="width: 1000px; height: 350px;" /></p>

상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다. 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.

낚시왕이 상어 낚시를 하는 격자판의 상태가 주어졌을 때, 낚시왕이 잡은 상어 크기의 합을 구해보자.

###  입력

첫째 줄에 격자판의 크기 R, C와 상어의 수 M이 주어진다. (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)

둘째 줄부터 M개의 줄에 상어의 정보가 주어진다. 상어의 정보는 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000) 로 이루어져 있다. (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.

두 상어가 같은 크기를 갖는 경우는 없고, 하나의 칸에 둘 이상의 상어가 있는 경우는 없다.

### 출력

낚시왕이 잡은 상어 크기의 합을 출력한다.

### 예제 입력 1 

~~~
4 6 8
4 1 3 3 8
1 3 5 2 9
2 4 8 4 1
4 5 0 1 4
3 3 1 2 7
1 5 8 4 3
3 6 2 1 2
2 2 2 3 5
~~~

### 예제 출력 1 

~~~
22
~~~

각 칸의 왼쪽 아래에 적힌 수는 속력, 오른쪽 아래는 크기, 왼쪽 위는 상어를 구분하기 위한 문자이다. 오른쪽 위에 ❤️는 낚시왕이 잡은 물고기 표시이다.

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/2cdb3192-ef2b-4a73-a10e-4eca1680d45f/-/preview/" style="width: 509px; height: 350px;" /></p>

<p style="text-align: center;">초기 상태</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/6d04f922-513e-4999-9e55-b900eb5daa26/-/preview/" style="width: 990px; height: 336px;" /></p>

<p style="text-align: center;">1초</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/6dde494f-feb0-4d4d-9e3a-212fe512d086/-/preview/" style="width: 990px; height: 340px;" /></p>

<p style="text-align: center;">2초 (E번 상어는 B번에게 먹혔다)</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/746cf841-05d5-4f5c-83c4-a4ddaf6e48d1/-/preview/" style="width: 990px; height: 333px;" /></p>

<p style="text-align: center;">3초</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/3341d3d9-6ce5-486f-a1d4-310c0acd43bc/-/preview/" style="width: 990px; height: 332px;" /></p>

<p style="text-align: center;">4초</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/92605c98-a0ae-4d57-bce4-abb6dab2a7bf/-/preview/" style="width: 990px; height: 330px;" /></p>

<p style="text-align: center;">5초</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/a4cea7b1-aa0d-4caa-b6ca-c4b3221601bd/-/preview/" style="width: 990px; height: 333px;" /></p>

<p style="text-align: center;">6초</p>

### 예제 입력 2 

~~~
100 100 0
~~~

### 예제 출력 2 

~~~
0
~~~

### 예제 입력 3 

~~~
4 5 4
4 1 3 3 8
1 3 5 2 9
2 4 8 4 1
4 5 0 1 4
~~~

### 예제 출력 3 

~~~
22
~~~

### 예제 입력 4 

~~~
2 2 4
1 1 1 1 1
2 2 2 2 2
1 2 1 2 3
2 1 2 1 4
~~~

### 예제 출력 4 

~~~
4
~~~

