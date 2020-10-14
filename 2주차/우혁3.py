# https://leetcode.com/problems/max-area-of-island/
class Solution:
    '''
        가장 많은 면적을 가지고 있는 섬을 확인하는 문제이다.
        섬이 없을 수도 있으니 최소 값은 0이 된다.
    '''
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        # 풀이
        # 배열을 검사하면서 0은 건너뛴다.
        # 1이 나올 경우 주변 네 방향의 값이 1인지 확인한다.
        # 0이 나올 때 까지 반복한다.
        # 1이 나올 경우 재귀를 통해 주변 값이 1인지 검사하는 방식으로 접근한다.
        # 네 방향 모두 방문를 하기에 이미 방문한 정점에 대한 처리가 필요하다.
        # 만약 방문처리가 되지 않는다면 이전 값으로의 중복 방문 또는
        # 다음 정점에서 그 다음 정점으로의 중복 접근이 발생하게 된다.
        # 예시)
        # [c][b][c]
        # [b][a][b]
        # [c][b][c]
        #
        # 정점 a에서 네 방향인 b를 방문한다. 
        # 정점 b에서 네 방향을 접근할 때, 각 c에는 두 번, 이미 방문한 a에는 4번을 방문하게 된다.
        # 공간복잡도를 줄이기 위해 방문 처리는 방문한 지점의 값을 0으로 변경하여 처리한다.

        # 접근 지점이 육지인지 확인하는 재귀함수이다.
        # 최초에 두 개의 값을 입력받아 해당 좌표부터 방문을 실시한다.
        def checkIsland(i, j):
            cnt = 0
            # 0이면 0을 반환한다.
            if grid[i][j] == 0:
                return 0
            # 방문 처리를 진행한다.
            grid[i][j] = 0
            cnt += 1
            # 이후 i와 j가 범위를 벗어나지 않는 선에 한하여 네 방향으로 함수를 호출한다.
            if i > 0:
                cnt += checkIsland(i - 1, j)
            if i < len(grid) - 1:
                cnt += checkIsland(i + 1, j)
            if j > 0:
                cnt += checkIsland(i, j - 1)
            if j < len(grid[i]) - 1:
                cnt += checkIsland(i, j + 1)
            return cnt

        result = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                cnt = checkIsland(i, j)
                result = max(cnt, result)
        return result