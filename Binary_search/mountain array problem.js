let a = [0, 2, 5, 3, 1];

// In Java- https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/1257661144/
const peakValue = (arr) => {
  let start = 0,
    end = arr.length;

  let mid = Math.floor((start + end) / 2);

  if (start > end) return;

  while (start < end) {
    if (arr[mid] < arr[mid + 1]) {
      start = mid + 1;
    } else {
      end = mid;
    }
    mid = Math.floor((start + end) / 2);
  }

  return start;
};

console.log(peakValue(a));
