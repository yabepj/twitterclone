function sum(){
    var s;
	for( i = 0; i < arguments.length; i++)
		s += arguments[i];
	return s;
}

console.log("we");

var serviceLoc =  "http://localhost:8080/";

function loadImages(){
	var person = document.getElementById("person").value;    
    var url = serviceLoc + person;
    loadDoc(url);
}


function loadDoc(url) {
    		var xhttp = new XMLHttpRequest();
    		xhttp.onreadystatechange = function() {
                   if( xhttp.readyState === 4 &&
						xhttp.status === 200){

							var json = xhttp.responseText;


							console.log(json);
							var content = JSON.parse(json);

							


						    var stuff = "";
	                        for( var i=0; i < content.length; i++){
	                        	
								//for( var attr in content[i]){
									//stuff += "<li>" + attr + ":" + content[i][attr]  + "</li>";
								   //  stuff += '<img src="' + 
								   //          'http://localhost:8080' + "/images/" +
											// content[i].url +
								   //  		'" title="' +
								   //  		content[i].description  +  '"/>';

								    stuff += '<a href="' +
								       'http://localhost:8080' + "/images/" +
									   content[i].url +
								       '" data-lightbox="image-1" data-title="' +
								       content[i].description  + 
								       '">' +
								       '<img class="img-thumbnail"' + 
								       	    ' id="id' + i  + '" ' +
								            'src="' + 
								            'http://localhost:8080' + "/images/" +
											content[i].url +
								    		'" title="' +
								    		content[i].description  +  '"/>'
								       '</a>';

								//}

								
	                        }

							document.getElementById("content").innerHTML
							 = "<p>" + stuff + "</p>";
                            
                            for( var i=0; i < content.length; i++){
								myimg = document.getElementById('id' + i);
								myimg.style.height = "200px";
								myimg.style.width = "200px"; 
							}

							document.getElementById("success")
								.setAttribute("class","alert alert-success");
						}
    		     
            };
    		
    		xhttp.open("GET", url ,true);
    		xhttp.send();

    	}

