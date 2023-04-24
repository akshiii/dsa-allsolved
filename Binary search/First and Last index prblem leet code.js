let a = [0, 0, 2, 2, 2, 3, 4];

const firstOccurance = (arr, key) => {
  let ans = -1;
  let start = 0,
    end = arr.length - 1;
  let mid = Math.floor((start + end) / 2);

  if (start > end) return console.log("No match found");

  while (start <= end) {
    if (arr[mid] == key) {
      ans = mid;
      //if equal now find left most occurance, so check before mid values
      end = mid - 1;
    } else if (arr[mid] > key) {
      end = mid - 1;
    } else if (arr[mid] < key) {
      start = mid + 1;
    }

    mid = Math.floor((start + end) / 2);
  }

  console.log(ans);
};

const lastOccurance = (arr, key) => {
  let ans = -1;
  let start = 0,
    end = arr.length - 1;
  let mid = Math.floor((start + end) / 2);

  if (start > end) return console.log("No match found");

  while (start <= end) {
    if (arr[mid] == key) {
      ans = mid;
      //if equal now find right most occurance, so check after mid values
      start = mid + 1;
    } else if (arr[mid] > key) {
      end = mid - 1;
    } else if (arr[mid] < key) {
      start = mid + 1;
    }

    mid = Math.floor((start + end) / 2);
  }

  console.log(ans);
};

lastOccurance(a, 2);

firstOccurance(a, 2);
