# https://www.acmicpc.net/problem/11399
'''
    모든 사람이 인출하는데 걸리는 시간의 최저 값을 구하는 문제.
    정렬 조건의 제한이 없으므로 최소 값을 기준으로 정렬.
'''

# 주어진 배열이 1 2 3 3 4 일 때,
# 1번은 1
# 2번은 1 + 2
# 3번은 1 + 2 + 3
# 4번은 1 + 2 + 3 + 3
# 5번은 1 + 2 + 3 + 3 + 4 의 시간이 소요되며, 총 32의 시간이 최소 값이 된다.
# 인덱스 0인 1은 배열의 길이인 5만큼 반복해서 등장하며,
# 인덱스가 1인 2는 4, 2인 3은 3, ..., 인덱스가 n인 m은 length - n만큼 등장하게 된다.
n = int(input())
nums = list(map(int, input().split()))
nums.sort()
total = 0
length = len(nums)
for i in range(length):
    # 인덱스 i에 해당하는 숫자는 length에서 현재 인덱스를 뺀 만큼 등장.
    total += nums[i] * (length - i)
print(total)
