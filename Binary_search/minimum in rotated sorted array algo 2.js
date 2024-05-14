var findMin = function (nums) {
  let start = 0,
    end = nums.length;

  let mid = Math.floor((start + end) / 2);

  if (start > end) return -1;

  if (nums[start] < nums[end - 1]) {
    //already sorted and not rotated
    return nums[start];
  }

  while (start < end) {
    if (nums[mid] >= nums[0]) {
      start = mid + 1;
    } else {
      end = mid;
    }
    mid = Math.floor((start + end) / 2);
  }

  return nums[start];
};
console.log(findMin([2, 1]));
// console.log(findMin([4, 2, 3]));
