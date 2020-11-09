'''
    주어진 문자열이 오름차, 내림차, 미정렬인지 판별하는 문제.
'''

arr = list(map(int, input().split()))
length = len(arr)
# 오름차, 내림차인지 저장하여 둘다 1이면 미정렬!
result = [0, 0]
for i in range(length - 1):
    if arr[i] < arr[i + 1]:
        result[0] = 1
    else:
        result[1] = 1
if(result[0] > result[1]):
    print('ascending')
elif(result[0] < result[1]):
    print('descending')
else:
    print('mixed')
