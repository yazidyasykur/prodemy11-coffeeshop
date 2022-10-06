

function loadHandler(){
	let docs = document.querySelectorAll("#table-body");
	
	for(let i = 0 ; i<docs.length; i++){
		let elements = "";
		let data = docs[i].getAttribute("data")
		let decodedData = decodeURIComponent(data);
		
		let parsedJson = JSON.parse(decodedData)
		
		for(item in parsedJson){
			elements += `<tr><td>${item}</td> <td>${parsedJson[item]}</td</tr>`
		}
		docs[i].innerHTML = elements;
	}
}

function deleteHandler(event){
	let id = event.target.id;
	var xhr = new XMLHttpRequest();
	var data = "orderId=" + encodeURIComponent(id); 
	xhr.open("POST", "deleteorder?" + data);
	xhr.send(data);
	window.location.reload();
}

