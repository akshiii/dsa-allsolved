//find smallest positive number(not 0) that is not in array

function solve(A) {
  let ans = 1;
  A.sort();

  for (let i = 0; i < A.length; i++) {
    if (ans == A[i]) {
      ans++;
    }
  }

  return ans;
}

console.log(solve([1, 3, 6, 4, 1, 2])); //5
console.log(solve([-1, -3])); //1
