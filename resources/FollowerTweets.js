


//function loadFollowerTweets(){


console.log("in the loadFollowersTweets...");
var myDate = new Date();
dataFile = "file:\\C:\Users\admin\GitTest\ssa4week\twitterclone\resources\twitterFollowerData.txt";


var mydata = JSON.parse(twitterFollowerData);
console.log("data:  " + JSON.stringify(mydata) );



document.getElementById("tweetDate").value = Date(); //myDate.toLocaleDateString()+myDate.toLocaleTimeString();
document.getElementById("follower").value = "Uma";
document.getElementById("tweetData").value = "I am in class";





//}