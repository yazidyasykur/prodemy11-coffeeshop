function listGenerator(){
	let docs = document.querySelectorAll("#orderlist");
	
	for(let i=0; i<docs.length; i++){
		let jsonAsString = docs[i].textContent;
		let json = JSON.parse(jsonAsString);
		let listString = ""
		
		for(item in json){
			listString += `
				<li>${item} x${json[item]}</li>
			`
		}
		docs[i].innerHTML = `<ol>${listString}</ol>`
	}
}