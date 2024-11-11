function calculateProbability(arr) {
  let finalPro = 0;
  let startingPoint = arr[0];
  let startingDivision = 100;
  for (let i = 1; i < arr.length; i++) {
    let nextStep = arr[i];
    if (nextStep[0] == startingPoint[0]) {
      //same row going sideways
      let prob = 90 / startingDivision;
      finalPro = finalPro + prob;
    } else {
      //going down
      let prob = 50 / startingDivision;
      finalPro = finalPro + prob;
    }
    startingDivision = startingDivision * 10;
  }

  console.log(finalPro);
}

calculateProbability([
  [0, 0],
  [0, 1],
  [1, 1],
  [2, 1],
]); // 0.955

calculateProbability([
  [0, 0],
  [0, 1],
  [0, 2],
  [1, 2],
]); //0.995
