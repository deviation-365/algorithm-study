'''
    문제를 보고 깊이 우선 탐색을 떠올렸다.
    주어진 이차원 배열을 모두 방문하며, 1인 경우 주변을 탐색!
'''
N = int(input())
graph = []
result = []
cnt = 0
for i in range(N):
    graph.append(list(input()))
def dfs(i, j):
    global cnt
    # 범위를 벗어나거나 0이라면 탐색 종료
    if i < 0 or j < 0 or i == N or j == N or graph[i][j] == '0':
        return
    # 1이므로 중복 검사를 배제하기 위해 0을 할당한 이후, cnt에 1을 더한다.
    graph[i][j] = '0'
    cnt += 1
    # 이후 4방향으로 탐색을 진행한다.
    dfs(i + 1, j)
    dfs(i - 1, j)
    dfs(i, j + 1)
    dfs(i, j - 1)
for i in range(N):
    for j in range(N):
        # 특정 지점을 방문할 때 마다, cnt에 0을 할당하며, 탐색을 시작한다.
        cnt = 0
        dfs(i, j)
        # cnt가 0보다 크다면 단지가 있으므로 result에 추가한다.
        if cnt > 0:
            result.append(cnt)
# 출력
print(len(result))
for i in sorted(result):
    print(i)
    