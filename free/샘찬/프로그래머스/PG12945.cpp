#include<iostream>

using namespace std;

int solution(int n) {
    long long int before = 0;
    long long int next = 1;
    long long int value = 0;
    for (int i = 0; i < n - 1; i++) {
        value = before + next;
        before = next;
        next = value % 1234567;
    }
    return value % 1234567;
}

int main(void) {
    cout << solution(1000000);
}
