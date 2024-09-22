function solution(D, T) {
  let P = Array(D.length).fill(0);
  let G = Array(D.length).fill(0);
  let M = Array(D.length).fill(0);
  for (let i = 0; i < T.length; i++) {
    let str = T[i];
    for (let j = 0; j < str.length; j++) {
      switch (str[j]) {
        case "P":
          P[i] = P[i] + 1;
          break;
        case "G":
          G[i] = G[i] + 1;
          break;
        case "M":
          M[i] = ++M[i];
          break;
      }
    }
  }

  let totalPSum = 0;
  let totalGSum = 0;
  let totalMSum = 0;
  let dist = 0;
  //   for (let i = 0; i < D.length; i++) {
  //     if (P[i] > 0) {
  //       totalPSum = totalPSum + 2 * (dist + D[i]) + P[i];
  //     }
  //     if (G[i] > 0) {
  //       totalGSum = totalGSum + 2 * (dist + D[i]) + G[i];
  //     }
  //     if (M[i] > 0) {
  //       totalMSum = totalMSum + 2 * (dist + D[i]) + M[i];
  //     }
  //     dist = dist + D[i];
  //   }

  let bigDist = 0;
  for (let i = 0; i < P.length; i++) {
    if (P[i] > 0) {
      totalPSum = totalPSum + D[i] + P[i];
      dist = bigDist;
    }
    bigDist = bigDist + D[i];
  }
  totalPSum = totalPSum + dist;

  bigDist = 0;
  dist = 0;
  for (let i = 0; i < P.length; i++) {
    if (G[i] > 0) {
      totalGSum = totalGSum + D[i] + G[i];
      dist = bigDist;
    }
    bigDist = bigDist + D[i];
  }
  totalGSum = totalGSum + dist;

  bigDist = 0;
  dist = 0;
  for (let i = 0; i < P.length; i++) {
    if (M[i] > 0) {
      totalMSum = totalMSum + D[i] + M[i];
      dist = bigDist;
    }
    bigDist = bigDist + D[i];
  }
  totalMSum = totalMSum + dist;

  let minTime = Math.max(totalPSum, Math.max(totalGSum, totalMSum));

  return minTime;
}

// console.log(solution([5, 8, 2, 7], 3)); //3
console.log(solution([2, 5], ["PGP", "M"])); //15
console.log(solution([3, 2, 4], ["MPM", "", "G"])); //19
console.log(solution([2, 1, 1, 1, 2], ["", "PP", "PP", "GM", ""])); //19

// dist = D[i];
