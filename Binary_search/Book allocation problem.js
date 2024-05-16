// Leetcode 410 - https://leetcode.com/problems/split-array-largest-sum/
let allocateBooks = (arr, students) => {
  let start = 0,
    sum = 0;

  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
  }

  let end = sum,
    ans = -1;

  let mid = Math.floor((start + end) / 2);

  while (start <= end) {
    if (isPossibleSolution(arr, students, mid)) {
      ans = mid;
      end = mid - 1;
    } else {
      start = mid + 1;
    }
    mid = Math.floor((start + end) / 2);
  }
  return ans;
};

let isPossibleSolution = (arr, students, mid) => {
  let studentCount = 1,
    pageSum = 0;

  for (let i = 0; i < arr.length; i++) {
    if (pageSum + arr[i] <= mid) {
      pageSum += arr[i];
    } else {
      studentCount++;
      if (studentCount > students || arr[i] > mid) {
        return false;
      }
      // this page sum is  for new student thats why we are only assigning new value and not adding with previous one
      pageSum = arr[i];
    }
  }
  return true;
};

// console.log(allocateBooks([1, 2, 3, 4], 3));
console.log(allocateBooks([2, 3, 1, 2, 4, 3], 5)); //op- 4
