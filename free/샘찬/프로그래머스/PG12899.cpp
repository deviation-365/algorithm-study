/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * 
 * 124의 나라
*/

#include <string>
#include <stack>

using namespace std;

string solution(int n) {
    string answer = "";
    char number[3] = {'1', '2', '4'};
    stack<int> s;
    n--;
    while (true) {
        if (n < 3) {
            s.push(n);
            break;
        }
        s.push(n % 3);
        n /= 3;
        n--;
    }
    while(!s.empty()) {
        answer += number[s.top()];
        s.pop();
    }
    
    return answer;
}