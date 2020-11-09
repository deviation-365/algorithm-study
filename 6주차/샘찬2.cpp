/*
    0에서 x까지의 거리(x), 0에서 y까지의 거리(y), x에서 w까지의 거리, y에서 h까지의 거리를 모두 비교 후 가장 짧은 수를 출력한다.
*/

#include <stdio.h>
#include <cmath>

int main(void) {
	int x, y, w, h;
	scanf("%d %d %d %d", &x, &y, &w, &h);
	int minX = x > abs(x - w) ? abs(x - w) : x;
	int minY = y > abs(y - h) ? abs(y - h) : y;
	int min = minX > minY ? minY : minX;
	printf("%d", min);
}
