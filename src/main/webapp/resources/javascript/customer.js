var listItem = {}
var listPrices = {}
var listAmount = {}

function orderHandler(){
	doAjax();
	printDiv('printableArea');
	window.location.reload();
}

function add(event) {
	addItem(event.target.id);
	register();
	addToReceipt();
}

function sub(event) {
	subItem(event.target.id);
	register();
	addToReceipt();
}

function addItem(id) {
	let docs = document.querySelector(`span#${id}`);
	let number = parseInt(docs.textContent) + 1;
	docs.innerHTML = number;
}

function subItem(id) {
	let docs = document.querySelector(`span#${id}`)
	if (parseInt(docs.textContent) > 0) {
		let number = parseInt(docs.textContent) - 1;
		docs.innerHTML = number;
	}
}

function register() {
	let docs = document.querySelectorAll(`span`);
	for (let i = 0; i < docs.length; i++) {
		let key = docs[i].attributes.key.nodeValue;
		let value = docs[i].innerText;
		let harga = docs[i].attributes.harga.nodeValue;

		let data = {
			"harga": harga,
			"jumlah": value
		}

		if (value == 0) {
			delete listItem[key];
			delete listPrices[key];
			delete listAmount[key];
		} else {
			listItem[key] = data;
			listPrices[key] = parseInt(harga) * parseInt(value);
			listAmount[key] = data.jumlah;
		}
	}
	totalPrices();
}

function totalPrices() {
	let total = Object.values(listPrices);
	total = total.reduce((a, b) => a + b);

	if (total > 0) {
		document.getElementById("totalAmount").innerHTML = `${total}`
	}
}

function addToReceipt() {
	let element = "";

	for (let item in listItem) {
		let amount = listItem[item].jumlah
		let price = listItem[item].harga * amount;
		element += `<tr><td>${item}</td> <td>${amount}</td> <td>${price}</td></tr>`
	}

	document.getElementById("list-table").innerHTML = element;
}

function nameHandler(event){
	let value = event.target.value;
	document.getElementById("nama").innerText = `${value}`
}

function loadHandler() {
	setInterval(setClock, 1000);
}

function setClock() {
	var time = new Date();
	let days = ["Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"]
	let months = ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"]
	document.getElementById("dateTime").innerHTML = `${days[time.getDay()]}, ${time.getDate()} ${months[time.getMonth()]} ${time.getFullYear()} ${time.getHours()} : ${time.getMinutes()} : ${time.getSeconds()}`
}

function printDiv(divName) {
	var printContents = document.getElementById(divName).innerHTML;
	var originalContents = document.body.innerHTML;

	document.body.innerHTML = printContents;

	window.print();

	document.body.innerHTML = originalContents;
}

function doAjax() {
	let nama = document.getElementById("nama").textContent;
	let time = new Date()
	let dateTime = time.getTime();
	let orderId = document.getElementById("orderId").textContent;
	let orders = JSON.stringify(listAmount);
	let totalAmount = document.getElementById("totalAmount").textContent;
	
	var xhr = new XMLHttpRequest();
	var data = "nama=" + encodeURIComponent(nama)
		+ "&dateTime=" + encodeURIComponent(dateTime)
		+ "&orderId=" + encodeURIComponent(orderId)
		+ "&orders=" + encodeURIComponent(orders)
		+ "&totalAmount=" + encodeURIComponent(totalAmount);
	xhr.open("POST", "saveorder?" + data);
	xhr.send(data);
}