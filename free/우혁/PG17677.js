function solution(str1, str2) {
  let regex = /^[a-zA-Z]+$/;
  str1 = str1.toUpperCase();
  str2 = str2.toUpperCase();

  const str1List = [];
  const str2List = [];
  for (let i = 0; i < str1.length - 1; i++) {
    const item = str1.substring(i, i + 2);
    if (regex.test(item)) str1List.push(item);
  }
  for (let i = 0; i < str2.length - 1; i++) {
    const item = str2.substring(i, i + 2);
    if (regex.test(item)) str2List.push(item);
  }

  let crossCount = 0,
    sumCount = 0;
  while (str1List.length) {
    const str = str1List.shift();
    for (let i = 0; i < str2List.length; i++) {
      if (str2List[i] === str) {
        str2List.splice(i, 1);
        crossCount++;
        break;
      }
    }
    sumCount++;
  }
  sumCount += str2List.length;
  const answer = crossCount / sumCount;
  return Math.floor(Number.isNaN(answer) ? 65536 : answer * 65536);
}
