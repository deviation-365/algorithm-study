/*
    무식하게 풀었다. x, y, z가 가장 긴 경우를 모두 체크한다.
*/

#include <stdio.h>
#include <cmath>
#include <vector>
#include <string>

using namespace std;

int main(void) {
	
	int x, y, z;
	vector<string> v;
	while (true) {
		scanf("%d %d %d", &x, &y, &z);
		if (x == 0) break;
		if (pow(x, 2) + pow(y, 2) == pow(z, 2) || pow(x, 2) + pow(z, 2) == pow(y, 2) || pow(y, 2) + pow(z, 2) == pow(x, 2)) {
			v.push_back("right");
		} else {
			v.push_back("wrong");
		}
	}
	
	for (int i = 0; i < v.size(); i++) {
		printf("%s\n", v[i].c_str());
	}
	
}
