function solution(name) {
  let answer = 0;
  Array.prototype.forEach.call(name, v => {
      const c = v.charCodeAt();
      answer += c > 77 ? 91 - c : c % 65;
  });
  let min = name.length - 1;
  Array.prototype.forEach.call(name, (v, i) => {
    let idx = i;
    if(v === 'A') {
        while(idx < name.length && name[idx] === 'A') { idx++; }
        const move = ((i - 1) * 2) + name.length - idx;
        min = min > move ? move : min;
    }
  });
  return answer + min;
}