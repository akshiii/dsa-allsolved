//unsolved
function powerSets(nums, outputs, index, ans) {
  //base case
  if (index >= nums.length) {
    ans.push(outputs);
  }

  //exclude
  powerSets(nums, outputs, index + 1, ans);

  //include
  let element = nums[index];
  outputs.push(element);
  powerSets(nums, outputs, index + 1, ans);

  console.log(nums);
}

let ans = powerSets(nums);
