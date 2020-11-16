/*
  완전 탐색을 통해 접근한다.
  8 * 8 단위로 탐색해야 함을 유의!
*/

const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let width = 0;
let height = 0;
let list = [];
rl.on('line', function(line) {
  if(width === 0) {
    const lineList = line.split(' ');
    width = +lineList[0];
    height = +lineList[1];
  } else if(list.length < width) {
    list.push(line);
  }
  if(list.length === width) {
    rl.close();
  }
}).on("close", function() {
  let result = 64;
  for(let i = 0; i + 7 < width; i++) {
    for(let j = 0; j + 7 < height; j++) {
      // flag로 맨 앞이 B인 경우와 W인 경우를 고려한다.
      for(let step = 0, flag = 'B'; step < 2; step++, flag = 'W') {
        let count = 0;
        // 8 * 8 범위 조건
        for(let k = i; k < i + 8; k++) {
          for(let l = j; l < j + 8; l++) {
            // i = 0, j = 0, flag = 'B'인 경우
            // BWB
            // BWW
            // BWB
            // 일 때, [0, 1], [1, 0], [1, 2], [2, 1] 지점은 flag와 달라야 하는 부분이다.
            // 그러므로 현재의 좌, 우에서 시작 지점을 뺀 값을 2로 나눈 나머지가 1인 경우에는 flag과 달라야 한다.
            if((l + k - i - j) % 2) {
              if(list[k][l] === flag) {
                count++;
              }
            } else {
            // i = 0, j = 0, flag = 'B'인 경우
            // BWB
            // BWW
            // BWB
            // 일 때, [0, 0], [1, 1], [1, 3], [2, 0], [2, 2] 지점은 flag와 동일해야 부분이다.
            // 그러므로 현재의 좌, 우에서 시작 지점을 뺀 값을 2로 나눈 나머지가 0인 경우에는 flag과 동일해야 한다.
              if(list[k][l] !== flag) {
                count++;
              }
            }
          }
        }
        result = count < result ? count : result;
      }
    }
  }
  console.log(result);
  process.exit();
});