function matchingStrings(stringList, queries) {
  // Write your code here
  let ans = Array(queries.length).fill(0);
  for (let i = 0; i < queries.length; i++) {
    for (let j = 0; j < stringList.length; j++) {
      if (j < stringList.length && queries[i] === stringList[j]) {
        ans[i] = ans[i] + 1;
        stringList.splice(j, 1);
        j--;
      }
    }
  }

  return ans;
}

let stringList = [
  "abcde",
  "sdaklfj",
  "asdjf",
  "na",
  "basdn",
  "sdaklfj",
  "asdjf",
  "na",
  "asdjf",
  "na",
  "basdn",
  "sdaklfj",
  "asdjf",
];
let queries = ["abcde", "sdaklfj", "asdjf", "na", "basdn"];
console.log(matchingStrings(stringList, queries));
console.log(matchingStrings(["fd", "a", "100"], [100]));
