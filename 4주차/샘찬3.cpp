#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int main(void) {

    int n;
    cin >> n;
    //쌍을 만들어 키와 몸무게 저장 (순서는 상관 없음)
    vector<pair<int, int>> d(n);
    for (int i = 0; i < n; i++) {
        cin >> d[i].first;
        cin >> d[i].second;
    }

    //순회하며 다른 사람과 비교
    for (int i = 0; i < n; i++) {
        //자신 보다 큰 사람의 수를 담는 변수
        int r = 0;
        for (int j = 0; j < n; j++) {
            //자신이면 확인하지 않음
            if (i == j) continue;

            //키, 몸무게가 자신보다 크면 +1 작거나 같으면 -1
            int a = 0;

            //몸무게 비교
            if (d[i].first < d[j].first) a++;
            else if (d[i].first >= d[j].first) a--;

            //키 비교
            if (d[i].second < d[j].second) a++;
            else if (d[i].second >= d[j].second) a--;

            //0보다 크다면 자신 보다 덩치가 큰 것이므로 증가
            if (a > 0) r++;
        }
        //자신보다 큰 사람이 r명 있으니 자신의 등수는 r+1 등이 된다.
        cout << r + 1 << ' ';
    }

}