/*
 * DFS를 이용하여 재귀적으로 풀어야하는 문제
 * 요소가 1이면 앞뒤좌우의 값도 1인지 판단하고 1이라면 dfs 함수를 계속 호출
 * */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int arr[25][25];
int cnt;

void dfs(int i, int j) {
    //요소가 0이거나 i와 j가 배열 길이를 벗어나면 빠져나옴
    if (!arr[i][j] || i == n || j == n || i < 0 || j < 0) {
        return;
    }
    //한 번 체크한 요소는 0으로 변경
    arr[i][j] = 0;
    //갯수 증가
    cnt++;
    //앞뒤좌우의 인덱스로 다시 호출
    dfs(i + 1, j);
    dfs(i - 1, j);
    dfs(i, j + 1);
    dfs(i, j - 1);
}

int main(void) {
    string l;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> l;
        for (int j = 0; j < n; j++) {
            arr[i][j] = l[j] - '0';
        }
    }
    vector<int> v;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            //정점이 1이라면
            if (arr[i][j]) {
                //새롭게 카운트를 시작
                cnt = 0;
                //해당 인덱스를 가지고 함수 호출
                dfs(i, j);
                //세어진 개수를 벡터에 넣음
                v.push_back(cnt);
            }
        }
    }
    sort(v.begin(), v.end());
    cout << v.size() << endl;
    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << endl;
    }

}
