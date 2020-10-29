/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 실패율
*/

#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

//정렬을 위한 함수
bool comp(pair<int, float> p1, pair<int, float> p2) {
    //값이 큰 수부터 내림차순으로 정렬한다.
    if (p1.second > p2.second) return true;
    else if (p1.second < p2.second) return false;
    //만약 값이 같다면 인덱스가 빠른 쪽이 먼저 정렬 된다.
    else return p1.first < p2.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    //클리어마다 도달했지만 클리어하지 못한 인원을 넣어 준다. (1부터 시작하기 위해 배열의 길이는 +1)
    vector<float> notClears(stages.size() + 1);
    //현재 스테이지에 있는 인원 들을 넣어 준다. (1부터 시작하기 위해 배열의 길이는 +1)
    vector<float> reachers(stages.size() + 1);
    //순회
    for (int i = 0; i < stages.size(); i++) {
        //도달한 사람의 스테이지를 인덱스로 하여 1씩 증가 시켜준다.
        notClears[stages[i]]++;
        //스테이지 만큼 순회하며 1번 스테이지 부터 증가 시킨다. (해당 스테이지를 지났다는 표시)
        for (int j = 1; j <= stages[i]; j++) {
            reachers[j]++;
        }
    }
    //스테이지와 실패율을 저장할 쌍을 만든다.
    vector<pair<int, float>> pairs(N);
    for (int i = 1; i <= N; i++) {
        //위에서 만든 데이터를 계산하여 넣어준다.
        pairs[i - 1] = make_pair(i, notClears[i] / reachers[i]);
    }
    //정렬한다.
    sort(pairs.begin(), pairs.end(), comp);
    
    //정렬된 순서대로 인덱스를 결과에 넣어준다.
    for (int i = 0; i < N; i++) {
        answer.push_back(pairs[i].first);
    }
    
    return answer;
}