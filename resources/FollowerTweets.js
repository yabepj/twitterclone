


//function loadFollowerTweets(){


console.log("in the loadFollowersTweets...");
var myDate = new Date();
var dataFile = "file:\\\\C:\Users\\admin\\GitTest\\ssa4week\\twitterclone\\resources\\twitterFollowerData.json";
//var dataFile = "file:resources\\twitterFollowerData.json";

loadDoc();
// console.log(JSON.stringify(mydata) );



function loadDoc() {
console.log(" FollowerTweets:  in loadDoc() ")	
  var xhttp;
  xhttp=new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState === 4 && xhttp.status === 200) {


	var JSONtext = JSON.parse(xhttp.responseText);
        console.log('JSONtext:  '  +  JSON.stringify(JSONtext));

		
   var JSONtext = xhttp.responseText;
   var myObject= JSON.parse(JSONtext);
    // Getting key,value pairs from Object
    var key, value;
	

	var tweets = myObject["userData"];
	console.log("tweets:  " + tweets);	
	
	var tweetDate  = "";
    var follower  = "";
    var tweetData  = "";
	
	var tweetDateCell;
    var followerCell;
	var tweetDataCell;
	
	var tableBody = document.getElementById("tweetTableBody");

	var tableRowCounter =0;
	
    for (key in tweets){
    	if(tweets.hasOwnProperty(key)){
             value = tweets[key];
			 tweetDate = value["date"] ;
             follower = value["name"]
             tweetData = value["tweet"];
			
    		}
console.log("key:" + key +   "   value:  " + value + "  tweetDate:  " +  tweetDate + "  follower: " + follower + "  tweetData:  " + tweetData);			

 
 
document.getElementById("tweetDate").value = tweetDate; //myDate.toLocaleDateString()+myDate.toLocaleTimeString();
document.getElementById("follower").value = follower;
document.getElementById("tweetData").value = tweetData;

var tweetTextArea = document.createElement('textarea');
			     

			
var row = tweetTableBody.insertRow(tableRowCounter++);
var  tweetDateCell = row.insertCell(0);
var followerCell = row.insertCell(1);
var tweetDataCell = row.insertCell(2);

// Add some text to the new cells:
tweetDateCell.innerHTML = tweetDate ;
followerCell.innerHTML = follower ;
tweetDataCell.innerHTML = tweetData ; 
			
   
    	}   
 
      
    }
  };

console.log("file to open:  " + dataFile);
//xhttp.open("GET",  dataFile, true);
xhttp.open("GET",  "twitterFollowerData.json", true);
  xhttp.send();
}



//}