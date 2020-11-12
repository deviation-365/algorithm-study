/*
 * 배열을 순회하면서 1인 경우에 인접 요소가 모두 0이 될 때까지 탐색
 * 만약 한 번이라도 dfs를 돌았다면 flag를 true로 변경
 * flag가 true인 경우 개수를 셈
 * */

#include <stdio.h>
#include <string.h>

using namespace std;

int arr[50][50] = {0,};
bool flag;
int n, m, t;

void dfs(int j, int k) {
    if (!arr[j][k] || j >= n || k >= m || j < 0 || k < 0) return;
    arr[j][k] = 0;
    flag = true;
    dfs(j + 1, k);
    dfs(j - 1, k);
    dfs(j, k + 1);
    dfs(j, k - 1);
}

int main(void) {
    int testCnt;
    scanf("%d", &testCnt);
    for (int i = 0; i < testCnt; i++) {
        int result = 0;
        scanf("%d %d %d", &n, &m, &t);
        //배열 초기화 후 값 입력 받음
        memset(arr, 0, sizeof(arr));
        for (int j = 0; j < t; j++) {
            int a, b;
            scanf("%d %d", &a, &b);
            arr[a][b] = 1;
        }

        //요소가 1이라면 탐색하고 탐색이 성공하면 개수를 1 증가 시킴
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (arr[j][k] == 1) {
                    flag = false;
                    dfs(j, k);
                    if (flag) result++;
                }
            }
        }
        printf("%d\n", result);
    }
}