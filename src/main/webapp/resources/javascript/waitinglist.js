

function loadHandler() {
	let docs = document.querySelectorAll("#table-body");
	let queue = document.querySelectorAll("#orderNo");

	let queuenum = 1;

	for (let i = 0; i < docs.length; i++) {
		let elements = "";
		let data = docs[i].getAttribute("data")
		let decodedData = decodeURIComponent(data);

		let parsedJson = JSON.parse(decodedData)

		queue[i].innerHTML = queuenum;

		for (item in parsedJson) {
			elements += `<tr><td>${item}</td> <td>${parsedJson[item]}</td</tr>`
		}
		docs[i].innerHTML = elements;
		queuenum++;
	}

	setTimeout(function() {
		window.location.reload(1);
	}, 10000);
}

function deleteHandler(event) {
	let id = event.target.id;
	var xhr = new XMLHttpRequest();
	var data = "orderId=" + encodeURIComponent(id);
	xhr.open("POST", "deleteorder?" + data);
	xhr.send(data);
	window.location.reload();
}

