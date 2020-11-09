'''
    x, y에서 경계점으로 가는 경로 중 가장 작은 값을 출력.
'''

x, y, w, h = list(map(int, input().split()))
print(min(x, y, w - x, h - y))