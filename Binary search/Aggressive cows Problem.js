let aggressiveCows = (arr, cows) => {
  let start = 0,
    maxi = -1;

  for (let i = 0; i < arr.length; i++) {
    maxi = Math.max(maxi, arr[i]);
  }
  let end = maxi,
    ans = -1;

  let mid = Math.floor((start + end) / 2);

  while (start < end) {
    if (isPossibleSolution(arr, cows, mid)) {
      ans = mid;
      start = mid + 1;
    } else {
      end = mid - 1;
    }
    mid = Math.floor((start + end) / 2);
  }
  return ans;
};

let isPossibleSolution = (arr, cows, mid) => {
  arr.sort();
  let cowCount = 1,
    lastPosition = arr[0];

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] - lastPosition >= mid) {
      cowCount++;
      if (cowCount == cows) {
        return true;
      }
      lastPosition = arr[i];
    }
  }

  return false;
};

console.log(aggressiveCows([2, 5, 6, 3, 4], 2));
