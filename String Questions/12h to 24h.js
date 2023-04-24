let convert = (time12h) => {
  //01:10 PM

  let [time, modifier] = time12h.split(" ");
  let [hour, minute] = time.split(":");

  if (modifier === "AM" && hour === "12") {
    hour = "00";
  }
  if (modifier === "PM") {
    hour = parseInt(hour) + 12;
  }

  console.log(time12h + " is " + hour + ":" + minute);
};

convert("12:00 PM");
