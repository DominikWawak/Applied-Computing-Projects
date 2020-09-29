
console.log("Starting Slidy");

function showWhatItIs(){
  var learnMore = document.getElementById("whatItIs");
  learnMore.style.color = "white";
  
  if(learnMore.style.display === "block"){
    learnMore.style.display = "none";
    learnMore.style.cursor = "pointer";
   

  }else{
   learnMore.style.display ="block";
  }
}

function showHow(){
  var learnMore = document.getElementById("usage");
  learnMore.style.color = "white";
  
  if(learnMore.style.display === "block"){
    learnMore.style.display = "none";
    learnMore.style.cursor = "pointer";
   

  }else{
   learnMore.style.display ="block";
  }
}
