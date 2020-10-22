/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
*/

#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    // 마지막에 0번째 인덱스와 마지막 인덱스 요소의 앞 뒤를 비교하기 위해 길이보다 2 크게 생성
    vector<int> arr(n + 2);
    // 0번째 요소는 쓰지 않을 것이기 때문에 -1로 선언
    arr[0] = -1;
    // 체육복의 개수 1개씩 할당
    for (int i = 1; i < n + 1; i++) {
        arr[i] = 1;
    }
    // 여분 가지고 있는 학생 + 1개
    for (int i = 0; i < reserve.size(); i++) {
        arr[reserve[i]]++;
    }
    // 잃어버린 학생 -1개
    for (int i = 0; i < lost.size(); i++) {
        arr[lost[i]]--;
    }
    // 자신의 체육복이 0개이고, 학생의 앞 뒤 중 여분 있는 학생이 있다면 여분이 있는 학생의 체육복 개수 -1 빌린 사람은 + 1
    for (int i = 1; i < n + 1; i++) {
        if (arr[i - 1] == 0 && arr[i] == 2) {
            arr[i - 1]++;
            arr[i]--;
        } else if (arr[i + 1] == 0 && arr[i] == 2) {
            arr[i]--;
            arr[i + 1]++;
        }
    }
    // 체육복이 1개 이상인 학생만큼 answer증가
    for (int i = 1; i < n + 1; i++) {
        if (arr[i]) answer++;
    }
    return answer;
}