# https://www.acmicpc.net/problem/11399
'''
    비교 대상인 배열과 확인하기 위한 배열이 주어진다.
    확인하기 위한 배열에 있는 원소가 비교 대상인 배열에 존재하는지 확인하는 문제.
'''

# in 연산자를 이용한 풀이
n = input()
nums = input().split()
m = input()
check = input().split()
print(' '.join([x in nums and 1 or 0 for x in check]))
# 시간초과 발생.
# 확인하기 위한 배열 check를 전부 조회하므로 시간 복잡도는 O(n)이다.
# in 연산은 대상이 되는 배열의 전체 요소를 탐색하므로 최악의 경우 시간 복잡도는 O(n)이 된다.
# 그러므로 시간 복잡도는 O(n^2)이 된다.
# 주어진 문제는 최대 길이가 500,000인 두 배열이 주어지며, 최악의 경우 2500억 회의 연산이 발생할 수 있다.
# 일반적으로 1억 회의 연산의 소요시간은 1초이므로, 위의 코드는 제한인 2초를 초과하게 되어 시간초과가 발생한다.

# 정렬과 이진탐색을 이용한 풀이
n = int(input())
# 이진 탐색을 위해 정렬한다.
nums = sorted(list(map(int, input().split())))
m = input()
check = list(map(int, input().split()))
# 시간 단축을 위해 배열 대신 문자열을 이용.
result = ''
for i in check:
    # s는 시작 지점, e는 종료 지점이다.
    s = 0
    e = n - 1
    tmp = '0'
    # 시작 지점이 종료 지점보다 커진다면 찾지 못한 경우이므로 반복문을 종료한다.
    while s <= e:
        # j는 중간 지점이다.
        j = (s + e) // 2
        if nums[j] == i:
            tmp = '1'
            break
        elif nums[j] > i:
            # 탐색 대상인 배열은 오름차 순으로 정렬되어 있으므로 중간 지점보다 현재 수가 작다면
            # 찾고 있는 수의 인덱스는 중간 지점보다 작다는 뜻이 된다.
            # 그러므로 종료 지점의 위치를 중간 지점보다 1 낮게 변경.
            e = j - 1
        else:
            # 반대의 경우는 시작 지점이 중간 지점보다 1 크게 된다.
            s = j + 1
    result += tmp + ' '
print(result)
# 파이썬의 정렬함수는 Timsort 알고리즘을 사용한다.
# Timsort는 최악의 경우 시간 복잡도가 O(n log n)이 된다.
# in 연산 대신 이진탐색을 이용하면 시간 복잡도는 O(log n)이며,
# 최종적인 시간 복잡도는 O(n log n) + O(n) * O(log n)이 된다.
# 최악의 경우에도 약 1,900만 회의 연산으로 처리가 가능하다.

