#include <stdio.h>

using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);
    //1000원을 냈다고 가정하기 때문에 1000에서 가격을 뺌
	int rest = 1000 - n;
    //코인의 종류 선언
	int coin[6] = {500, 100, 50, 10, 5, 1};
	int answer = 0;
    //배열을 돌면서 현재 인덱스의 동전보다 거스름돈이 적으면 동전을 최대한 주고 그 결과를 거스름 돈에서 제외한다.
	for (int i = 0; i < 6; i++) {
		if (rest >= coin[i]) {
			int result = rest / coin[i];
			answer += result;
			rest -= coin[i] * result;
		}
	}
	printf("%d", answer);
	
}
