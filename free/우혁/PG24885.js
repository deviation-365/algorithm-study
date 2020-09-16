function solution(people, limit) {
  let answer = 0;
  people.sort((a, b) => a - b);
  let left = 0,
    right = people.length - 1;
  while (left < right) {
    const sum = people[left] + people[right];
    if (sum > limit) {
      right--;
    } else {
      left++;
      right--;
    }
    answer++;
  }
  if (left === right) {
    answer++;
  }
  return answer;
}
