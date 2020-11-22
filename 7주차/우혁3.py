n = int(input())
# arr[i][0] = 소요일, arr[i][1] = 점수
arr = [list(map(int, input().split())) for _ in range(n)]
# 문제 조건에서 최대 소요일은 5일이므로 indexError를 방지하기 위해 n + 6의 길이로 할당한다.
dp = [0] * (n + 6)

# i를 오늘이라고 생각한다.
for i in range(n):
    # 오늘의 포인트가 내일의 포인트보다 크다면 내일의 최댓값은 오늘과 같다.
    if dp[i] > dp[i + 1]:
        dp[i + 1] = dp[i]
    # 오늘에서 상담일이 지난 후의 포인트보다 오늘 포인트와 오늘 상담 포인트의 합이 크다면 상담을 진행하는게 최댓값이 된다.
    if dp[i + arr[i][0]] < dp[i] + arr[i][1]:
        dp[i + arr[i][0]] = dp[i] + arr[i][1]
print(dp[n])