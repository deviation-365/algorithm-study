function solution(brown, yellow) {
  for (let i = yellow; i >= 0; i--) {
    if (yellow % i !== 0) continue;
    if (2 * i + (2 * (yellow / i) + 4) === brown)
      return [i + 2, yellow / i + 2];
  }
}
