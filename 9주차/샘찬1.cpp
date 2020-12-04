/**
 * 소수를 먼저 구한 후 계산한다.
 * 
*/

#include <stdio.h>

using namespace std;

int main() {

    int max = 123456 * 2 + 1;
    int arr[max];
    for (int i = 2; i <= max; i++) {
        arr[i] = i;
    }
    for (int i = 2; i <= max; i++) {
        if (!arr[i]) {
            continue;
        }
        for (int j = i + i; j <= max; j += i) {
            arr[j] = 0;
        }
    }

    int n;
    int count;
    while (true) {
        scanf("%d", &n);
        if (n == 0) break;
        count = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (arr[i]) {
                count++;
            }
        }

        printf("%d\n", count);
    }
    
}