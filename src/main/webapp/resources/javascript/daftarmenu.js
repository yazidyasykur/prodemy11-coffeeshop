function submitHandler(){
	
	let count = 0;
	
	let id = document.getElementById("menuId").value;
	let nama = document.getElementById("menuNama").value;
	let jenis = document.getElementById("menuTipe").value;
	let gambar = document.getElementById("menuGambar").value;
	let deskripsi = document.getElementById("menuDeskripsi").value;
	let harga = document.getElementById("menuHarga").value;
	
	if(id.length!==0){
		count++;
	}
	
	if(nama.length!==0){
		count++;
	}
	
	if(jenis.length!==0){
		count++;
	}
	
	if(gambar.length!==0){
		count++;
	}
	
	if(deskripsi.length!==0){
		count++;
	}
	
	if(harga.length!==0 && !isNaN(harga)){
		count++;
		console.log(harga);
	}
	
	if(count !== 6){
		alert("Isi form tidak valid!")
	} else {
		document.getElementById("menu-form").submit();
	}
}