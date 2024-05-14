var findMin = function (nums) {
  let start = 0,
    end = nums.length;

  let mid;

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
findMin([7, 9, 1, 2, 3]);
