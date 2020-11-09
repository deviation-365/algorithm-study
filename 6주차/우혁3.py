'''
    dfs!
'''

import sys
sys.setrecursionlimit(10000)

def dfs(i, j):
    global arr, M, N
    # 배열의 범위를 벗어난다면 리턴
    if(i >= M or j >= N or i < 0 or j < 0 or arr[i][j] == 0):
        return
    # 함수로 호출된 시점에서 이미 주변에 배추가 있으므로 방문처리를 진행한다.
    arr[i][j] = 0
    dfs(i - 1, j)
    dfs(i, j - 1)
    dfs(i + 1, j)
    dfs(i, j + 1)

t = int(input())
for _ in range(t):
    cnt = 0
    M, N, K = map(int, input().split())
    arr = [[0]*N for _ in range(M)]
    for i in range(K):
        x, y = map(int, input().split())
        arr[x][y] = 1
    for i in range(M):
        for j in range(N):
            # 배추(1)가 있다면 dfs를 호출한다.
            if(arr[i][j] == 1):
                cnt += 1
                dfs(i, j)
    print(cnt)
