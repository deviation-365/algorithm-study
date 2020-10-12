/**
* https://leetcode.com/problems/relative-sort-array/submissions/
*/

import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //결과를 담을 배열 선언
        int[] arr3 = new int[arr1.length];
        //결과 배열의 인덱스 선언
        int index = 0;
        //arr2 요소를 첫 번째부터 차례대로 arr1에 있는 지 검사하면서 있으면 arr3 배열에 삽입
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    arr3[index++] = arr1[j];
                    // 삽입 후 삽입되었다는 표시로 -1를 재할당
                    arr1[j] = -1;
                }
            }
        }
        //arr2에 포함되지 않아 걸러지지 않은 요소들과 걸러진 -1의 값들을 정렬
        Arrays.sort(arr1);
        for (int a : arr1) {
            // -1이 아니라면 차례대로 삽입
            if (a != -1) {
                arr3[index++] = a;
            }
        }
        //결과반환
        return arr3;
    }
}
