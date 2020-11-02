'''
    가장 적은 개수의 잔돈을 반환해야 하므로 큰 금액부터 비교하면 된다.
'''
price = 1000 - int(input())
coin = [500, 100, 50, 10, 5, 1]
total = 0
for n in coin:
    cnt = price // n
    price -= cnt * n
    total += cnt
print(total)
