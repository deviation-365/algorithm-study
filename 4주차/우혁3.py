# https://www.acmicpc.net/problem/7568
'''
    키와 몸무게가 모두 큰 경우에만 덩치가 큰 것으로 인정하며,
    중복되는 순위가 있을 경우 다음 순위는 그 개수만큼 건너뛰게 된다.
'''

n = int(input())
persons = []
for _ in range(n):
    persons.append(list(map(int, input().split())))
result = ''
for i in range(n):
    # 최초의 순위는 1이 된다.
    # 이후 현재 사람보다 키, 몸무게가 모두 큰 사람이 있을 때 마다 순위는 밀려난다.
    rank = 1
    for j in range(n):
        if i == j:
            continue
        if persons[i][0] < persons[j][0] and persons[i][1] < persons[j][1]:
            rank += 1
    result += str(rank) + ' '
print(result)
