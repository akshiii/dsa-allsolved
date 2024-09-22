function solution(D, X) {
  let balance = 0;
  let count = 0;

  let i = 0;
  while (i < D.length) {
    let a = D[i];
    if (i < D.length) {
      let b = D[i + 1];
      if (Math.abs(b - a) <= X) {
        balance = X - Math.abs(b - a);
        if (balance > 0) {
          while (balance > 0) {
            if (i + 1 < D.length && Math.abs(b - D[i + 2]) <= balance) {
              i++;
              count++;
              balance = balance - Math.abs(b - D[i + 2]);
            } else {
              balance = -1;
            }
          }
        } else {
          count++;
          i++;
        }
      } else {
        count++;
      }
    } else {
      count++;
    }
    i++;
  }

  return count;
}

// console.log(solution([5, 8, 2, 7], 3)); //3
console.log(solution([2, 5, 9, 2, 1, 4], 4)); //3
