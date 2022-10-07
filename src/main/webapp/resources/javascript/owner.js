function formatter(){
	let idDocs = document.querySelectorAll("#orderlist");
	let dateDocs = document.querySelectorAll("#orderdate");
	let amountDocs = document.querySelectorAll("#amount");
	
	for(let i=0; i<idDocs.length; i++){
		let jsonAsString = idDocs[i].textContent;
		let json = JSON.parse(jsonAsString);
		let listString = ""
		
		for(item in json){
			listString += `
				<li>${item} x${json[item]}</li>
			`
		}
		idDocs[i].innerHTML = `<ol>${listString}</ol>`
	}
	
	for(let i=0; i<dateDocs.length; i++){
		let millis = dateDocs[i].textContent;
		millis = parseInt(millis);
		
		const date = new Date(millis);
		let stringdate = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}
		 ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}
		`
		dateDocs[i].innerHTML = stringdate;
	}
	
	let sum = 0;
	for(let i=0; i<amountDocs.length; i++){
		let amount = amountDocs[i].textContent;	
		sum += parseInt(amount);
	}
	console.log(sum);
	document.getElementById("penjualan").innerHTML = `Rp. ${sum}`;
	
	
}

function dateFormatter(date){
	return date + "formatt";
}