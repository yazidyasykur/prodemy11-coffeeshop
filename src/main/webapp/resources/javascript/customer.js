function add(event){
	addItem(event.target.id);
}

function sub(event){
	subItem(event.target.id);
}

function addItem(id){
	let docs = document.querySelector(`span#${id}`);
	let number = parseInt(docs.textContent) + 1;
	docs.innerHTML = number;
}

function subItem(id){
	let docs= document.querySelector(`span#${id}`)
	if(parseInt(docs.textContent) > 0){
		let number = parseInt(docs.textContent) - 1;
		docs.innerHTML = number;
	}
}

function loadHandler(){
	setInterval(setClock, 1000);
}

function setClock(){
	let time = new Date();
	let days = ["Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"]
	let months = ["Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"]
	document.getElementById("date").innerHTML = `${days[time.getDay()]}, ${time.getDate()} ${months[time.getMonth()]} ${time.getFullYear()} ${time.getHours()} : ${time.getMinutes()} : ${time.getSeconds()} 
}
