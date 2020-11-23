a, b, c = sorted(map(int, input().split()))
while a != 0:
    if a ** 2 + b ** 2 == c ** 2:
        print('right')
    else:
        print('wrong')
    a, b, c = sorted(map(int, input().split()))