#include <cstdio>
#include <algorithm>

using namespace std;

//카드를 담을 배열 (최대 500000까지 주어질 있으니 배열의 길이를 500001로 선언)
int arr[500001];

/*
    이진탐색으로 시간 복잡도가 O(logN)이 된다.

    이진탐색의 구현
        1. 배열의 중앙 값을 확인 후 찾으려는 값과 같으면 반환한다.
        2. 값이 다르다면, 중앙을 기준으로 2개로 나눈 후 값이 작으면 좌측 배열, 값이 크면 우측 배열을 다시 탐색 한다.
        3. 중앙의 값이 찾으려는 값과 같을 때까지 배열을 쪼개며 탐색한다.
        4. 배열의 길이가 0이 된다면 없다고 판단 하고 0을 반환한다.
*/
int bs(int num, int end) {
    int start = 0;
    int mid;
    while (end >= start) {
        mid = (start + end) / 2;
        if (arr[mid] == num) {
            return 1;
        } else if (arr[mid] > num) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return 0;
}

int main(void) {
    int n, m;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    //이진 탐색을 하기 위해 받은 값을 정렬한다.
    sort(arr, arr + n);
    scanf("%d", &m);
    for (int i = 0; i < m; i++) {
        int num;
        scanf("%d", &num);
        //값을 입력 받으면서 있는 지 확인 후 출력
        bs(num, n - 1) ? printf("%d ", 1) : printf("%d ", 0);
    }
}
