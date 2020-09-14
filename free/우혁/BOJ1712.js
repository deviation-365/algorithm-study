const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", function (line) {
  const [initial, cost, price] = line.split(" ").map((v) => +v);
  if (cost >= price) {
    console.log(-1);
  } else {
    console.log(Math.floor(initial / (price - cost)) + 1);
  }
  rl.close();
}).on("close", function () {
  process.exit();
});
