var findMin = function (nums) {
  let start = 0,
    end = nums.length;

  let mid;

  if (start > end) return -1;

  if (nums[start] <= nums[end]) {
    //already sorted and not rotated
    return nums[start];
  }

  while (start <= end) {
    mid = Math.floor((start + end) / 2);

    if (nums[mid] > nums[mid + 1]) {
      return nums[mid + 1];
    } else if (nums[mid] < nums[mid - 1]) {
      return nums[mid];
    } else if (nums[start] <= nums[mid]) {
      start = mid + 1;
    } else if (nums[mid] <= nums[end]) {
      end = mid - 1;
    }
  }
  return -1;
};

findMin([1, 2, 3, 4]);
