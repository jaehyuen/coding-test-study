# 백도어  
### 문제

상수는 2차원 배열 A[1..n][1..n] (n≥2, n은 자연수)을 가지고 있습니다. 이 배열의 각 원소는 1 이상 222 이하의 정수입니다.

배열을 가지고 놀던 상수를 본 승현이는, 질투심이 불타올라 상수를 A[1][1]에 가둬 버렸습니다! 최소한의 양심이 있던 승현이는 A[n][n]에 출구를 만들어 놓고 이 사실을 상수에게 알려줬습니다.

<img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11909/1.png"  width="300" height="300"/>

[그림 1] n=4라면 상수는 A[1,1]에 있고, 출구는 A[4][4]에 있습니다.

상수는 가능한 한 빨리 출구인 A[n][n]에 도달하고자 합니다. 상수가 A[i][j]에 있다고 가정했을 때, 상수는 최단 경로로 이동하기 위해 아래와 같은 조건을 만족하며 이동합니다.

1. 1≤i,j<n이라면, 상수는 A[i][j+1] 또는 A[i+1][j]로만 건너갑니다.
2. i=n,1≤j<n이라면, A[i][j+1]로만 건너갑니다.
3. 1≤i<n,j=n이라면 A[i+1][j]로만 건너갑니다.
4. i=j=n인 경우 바로 출구로 갑니다.

<img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11909/2.png"  width="300" height="300"/>

[그림 2] n=5라고 가정합시다. (ㄱ)는 1번 조건을 만족하고, (ㄴ)는 2번 조건을 만족하며, (ㄷ)는 3번 조건을 만족합니다.

그러나 건너갈 때에도 제약이 따릅니다. 상수가 A[a][b]에서 A[c][d]로 건너가려면 A[a][b]>A[c][d]를 만족해야 합니다. 상수는 왜인지 이런 조건을 만족하면서 이동할 수 없을 것 같았습니다. 다행히도, 승현이가 상수를 배열에 가둬버리기 전에, 상수는 배열의 각 원소에 버튼을 만들어 놓아서, 이 버튼을 누르면 해당 원소의 값이 1 증가하도록 했습니다. (물론 상수는 자신이 위치해 있는 원소의 버튼만 누를 수 있습니다.) 이 버튼 덕분에, 상수는 항상 배열을 탈출할 수 있습니다!

<img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11909/3.png"  width="200" height="200"/>

[그림 3] n=2라고 가정합시다. A[1][1]=5>A[1][2]=2이므로, 상수는 A[1][1]에서 A[1][2]로 건너갈 수 있습니다. 상수가 A[1][1]에서 A[2][1]로 건너가려면, A[1][1]에 있는 버튼을 두 번 눌러 A[1][1]의 값을 7로 만들면 됩니다.

하지만 버튼을 한 번 누르는 데에는 1원의 비용이 듭니다. 상수는 돈을 가능한 한 적게 들이면서 배열을 탈출하고자 합니다. 상수를 도와주세요.

### 입력

첫 번째 줄에 분기점의 수와 분기점들을 잇는 길의 수를 의미하는 두 자연수 N과 M이 공백으로 구분되어 주어진다.(1 ≤ N ≤ 100,000, 1 ≤ M ≤ 300,000)

두 번째 줄에 각 분기점이 적의 시야에 보이는지를 의미하는 N개의 정수 a0, a1, ..., aN-1가 공백으로 구분되어 주어진다. ai가 0이면 i 번째 분기점이 상대의 시야에 보이지 않는다는 뜻이며, 1이면 보인다는 뜻이다. 추가적으로 a0 = 0, aN-1 = 1이다., N-1번째 분기점은 상대 넥서스이기 때문에 어쩔 수 없이 상대의 시야에 보이게 되며, 또 유일하게 상대 시야에 보이면서 갈 수 있는 곳이다.

다음 M개의 줄에 걸쳐 세 정수 a, b, t가 공백으로 구분되어 주어진다. (0 ≤ a, b < N, a ≠ b, 1 ≤ t ≤ 100,000) 이는 a번째 분기점과 b번째 분기점 사이를 지나는데 t만큼의 시간이 걸리는 것을 의미한다. 연결은 양방향이며, 한 분기점에서 다른 분기점으로 가는 간선은 최대 1개 존재한다.

### 출력

첫 번째 줄에 유섭이의 챔피언이 상대 넥서스까지 안 들키고 가는데 걸리는 최소 시간을 출력한다. 만약 상대 넥서스까지 갈 수 없으면 -1을 출력한다.

### 예제 입력 1

~~~
5 7
0 0 0 1 1
0 1 7
0 2 2
1 2 4
1 3 3
1 4 6
2 3 2
3 4 1
~~~

### 예제 출력 1

~~~
12
~~~

### 예제 입력 2

~~~
5 7
0 1 0 1 1
0 1 7
0 2 2
1 2 4
1 3 3
1 4 6
2 3 2
3 4 1
~~~

### 예제 출력 2

~~~
-1
~~~