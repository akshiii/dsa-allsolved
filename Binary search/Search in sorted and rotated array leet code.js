var search = function (nums, target) {
  var findPivot = function (nums) {
    let start = 0,
      end = nums.length - 1;

    let mid = Math.floor((start + end) / 2);

    if (start > end) return -1;

    if (nums[start] < nums[end]) {
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

    return start;
  };

  var binarySearch = function (arr, value, start, end) {
    let mid = Math.floor((start + end) / 2);

    // if(start>end) return -1;

    while (start <= end) {
      if (arr[mid] == value) {
        return mid;
      } else if (arr[mid] > value) {
        end = mid - 1;
      } else if (arr[mid] < value) {
        start = mid + 1;
      }

      mid = Math.floor((start + end) / 2);
    }
    return -1;
  };

  let pivot = findPivot(nums);

  if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
    // BS on right side
    return binarySearch(nums, target, pivot, nums.length - 1);
  } else {
    //BS on left side
    return binarySearch(nums, target, 0, pivot - 1);
  }
};
console.log(search([3, 5, 1], 1));
