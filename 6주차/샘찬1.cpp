/*
 * 입력을 받으며 바로 이전에 받은 입력값과 비교한다.
 * */

#include <stdio.h>
#include <string>

using namespace std;

int main(void) {
    int asc = 0;
    int desc = 0;
    int prev, cur;
    string answer;
    scanf("%d", &prev);
    for (int i = 1; i < 8; i++) {
        scanf("%d", &cur);
        //이전 값이 현재 값 보다 크면 desc로 설정
        if (prev > cur) {
            desc = 1;
        }
        //이전 값이 현재 값 보다 작으면 asc로 설정
        if (cur > prev) {
            asc = 1;
        }
        prev = cur;
        //둘다 설정되어 있으면 mixed를 출력 후 종료
        if (desc + asc == 2) {
            printf("mixed");
            return 0;
        }
    }
    //출력
    if (desc) printf("descending");
    else printf("ascending");
}