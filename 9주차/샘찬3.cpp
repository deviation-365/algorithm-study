/**
 * 0이 입력될 때마다 값을 넣을 배열의 인덱스를 1 줄이고, 마지막으로 입력된 인덱스까지 더한다.
*/

#include <stdio.h>

using namespace std;

int main(void) {

	int n;
	scanf("%d", &n);
	int arr[n];
	int j = 0;
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[j]);
		if (arr[j] == 0) {
			j--;
		} else {
			j++;
		}
	}
	
	long long int sum = 0;
	for (int i = 0; i < j; i++) {
		sum += arr[i];
	}
	
	printf("%lld", sum);
	
}
