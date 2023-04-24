let selectionSort = (arr) => {
  let arrLength = arr.length - 1;

  for (let i = 0; i <= arrLength - 1; i++) {
    let minIndex = i;
    for (let j = i + 1; j <= arrLength; j++) {
      if (arr[j] < arr[minIndex]) minIndex = j;
    }
    let temp = arr[minIndex];
    arr[minIndex] = arr[i];
    arr[i] = temp;
  }
  return arr;
};
console.log(selectionSort([22, 24, 29, 11, 7]));
