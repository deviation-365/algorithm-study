/**
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * 
 * 키패드 누르기
*/

#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    /**
     * 가상의 배열을 생각하자
     *    {-1  1  2  3}
     *    {-1  4  5  6}
     *    {-1  7  8  9}
     *    {-1  *  0  #}
     *
     *      *, 0, # 을 제외한 숫자는 i번째 인덱스 * 3 + 나머지로 만들어 좌표 값으로 활용
     *          => i * 3 + r = number
     *          ex) 7 = 2 * 3 + 1 => (2, 1)
    */

    //최근 손가락의 좌표
    int lastL[2] = {3, 1}; // *
    int lastR[2] = {3, 3}; // #

    for (int i = 0; i < numbers.size(); i++) {
        // 왼손 엄지 (1, 4, 7)
        if (numbers[i] % 3 == 1) {
            answer += "L";
            lastL[0] = numbers[i] / 3;
            lastL[1] = numbers[i] - lastL[0] * 3;
        // 오른손 엄지 (3, 6, 9)
        } else if (numbers[i] != 0 && numbers[i] % 3 == 0) {
            answer += "R";
            lastR[0] = numbers[i] / 3 - 1; //3,6,9는 1,2,3으로 나누어 떨어지기 때문에 인덱스로 만들기 위해 -1을 해줌
            lastR[1] = numbers[i] - lastR[0] * 3;
        // 양쪽 엄지 모두 (0, 2, 5, 8)
        } else {
            // 해당 번호의 좌표를 구함
            int a[2];
            // 0인 경우 따로 처리
            if (numbers[i] == 0) {
                a[0] = 3;
                a[1] = 2;
            } else {
                a[0] = numbers[i] / 3;
                a[1] = numbers[i] - a[0] * 3;
            }
            // 왼손 엄지와 좌표의 거리 차이
            int l = abs(a[0] - lastL[0]) + abs(a[1] - lastL[1]);
            // 오른손 엄지와 좌표의 거리 차이
            int r = abs(a[0] - lastR[0]) + abs(a[1] - lastR[1]);

            string select;
            // 오른손 엄지가 더 멀면 왼손 엄지로 누름
            if (r > l) select = "L";
            // 왼손 엄지가 더 멀면 오른손 엄지로 누름
            else if (l > r) select = "R";
            else {
                // 둘의 거리가 같으면 주로 쓰는 손라락으로 누름
                if (hand == "left") select = "L";
                else select = "R";
            }
            // L or R 더해줌
            answer += select;
            // 누른 손가락 엄지의 좌표를 변경
            if (select == "L") {
                lastL[0] = a[0];
                lastL[1] = a[1];
            } else {
                lastR[0] = a[0];
                lastR[1] = a[1];
            }
            
        }
    }
    
    return answer;
}