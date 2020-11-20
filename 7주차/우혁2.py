n, m = map(int, input().split())
s = []
queue = []
# 이동할 수 있는 x와 y좌표
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
for i in range(n):
    s.append(list(input()))
# 시작 지점인 0, 0을 큐에 삽입한다.
queue = [[0, 0]]
s[0][0] = 1
while queue:
    # queue에 들어가있는 좌표를 a와 b에 할당. 즉, a와 b는 현재 지점의 x, y 값이 된다.
    a, b = queue[0]
    # 할당이 완료됐으니 삭제한다.
    del queue[0]
    # 현재 지점에서는 상하좌우로 이동이 가능하다.
    # i를 0부터 dx, dy의 인덱스에 접근하면 [1, 0], [-1, 0], [0, 1], [0, -1]이 된다.
    for i in range(4):
        x = a + dx[i]
        y = b + dy[i]
        # x나 y가 범위에 있으면서 이동할 수 있는 칸이라면 queue에 좌표를 삽입한다.
        if 0 <= x < n and 0 <= y < m and s[x][y] == "1":
            queue.append([x, y])
            # 다음 경로의 값은 현재 지점의 값의 + 1이 된다.
            s[x][y] = s[a][b] + 1
print(s[n - 1][m - 1])