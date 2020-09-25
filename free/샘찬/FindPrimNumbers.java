// 특정 수 내의 소수 개수 구하기

public class FindPrimeNumbers {
  
    // 정답은 나오지만 n이 커질 수록 기하급수적으로 느려짐
    public void myCode(int n) {
        int answer = 0;
        int index = 0;
        int[] arr = new int[n];
        for (int i = 2; i <= n; i++) {
            boolean isDecimal = true;
            for (int j = 0; arr[j] != 0; j++) {
                if (i % arr[j] == 0) {
                    isDecimal = false;
                    break;
                }
            }
            if (isDecimal) {
                arr[index++] = i;
                answer++;
            }
        }
        return answer;
    }

    /**
        에라토스테네이스의 체 (Sieve of Eratosthenes)

        100까지의 소수를 구한다고 했을 때
        2부터 100까지의 수를 배열에 넣고
        
        2부터 100까지 반복문을 돌며
        2를 제외한 2의 배수 제거
        3을 제외한 3의 배수 제거
        ...

        하지만 이렇게 되면 10000개일시 10000번을 검사해야 하므로
        이미 체크한 배수이면 제외하고 돈다 ex) 2의 배수 4, 6, 8, 10...n*2
    */

    public int sieveOfEratosthenes(int n) {
        int answer = 0;
        int[] arr = new int[n - 1];
        for (int i = 0; i + 2 <= n; i++) {
            arr[i] = i + 2;
        }
        for (int i = 0; i + 2 <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = 0; j + 2 <= n; j++) {
                if (arr[j] != (i + 2) && arr[j] % (i + 2) == 0) {
                    arr[j] = 0;
                }
            }
        }
        for (int a : arr) {
            if (a != 0) {
                answer++;
            }
        }

        return answer;
    }

}