<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
	<head>
		<script src="resources/javascript/customer.js"></script>
		<link rel="stylesheet" href="resources/css/customer.css">
	</head>

  <body onload="loadHandler()">
    <header>
      <nav class="flex items-center justify-between bg-[#2C3639] p-3 outline outline-4 outline-[#A27B5C]">
        <p class="font-semibold text-white">Sigma Coffee</p>
        <button class="rounded-lg p-2 text-white outline outline-1">Login</button>
      </nav>
    </header>
    <main class="m-3">
      <div class="flex gap-2.5">
        <div class="w-4/6 p-3 lg:w-9/12">
        <div class="flex flex-col px-2 mb-3">
          <label class="font-bold mb-2">Nama: </label>
          <input type="text" oninput="nameHandler(event)" class="text-lg outline outline-1 rounded indent-2"></input>
        </div>
          <h2 class="px-2 text-lg font-bold">Menu</h2>
          <div class="flex max-h-fit flex-col gap-3 overflow-y-auto p-3">
            
            <c:forEach items="${allMenu}" var="menu">
            
            <div id="${menu.menuId}" name="menuId" class="relative flex gap-2 rounded pr-4 shadow-md shadow-slate-600 outline outline-1">
              <img src="${menu.menuGambar}" class="w-40 lg:w-52" />
              <div class="flex max-h-36 flex-col py-2 w-full">
                <div class="flex items-center justify-between">
                  <h2 class="font-semibold">${menu.menuNama}</h2>
                  <p class="">Rp. ${menu.menuHarga}</p>
                </div>
                <p class="mb-5 overflow-y-auto text-xs lg:text-sm">${menu.menuDeskripsi}</p>
                <div class="lg:text-md absolute right-3 bottom-3 flex w-fit gap-3 justify-self-end rounded outline outline-1">
                  <svg id="${menu.menuId}" onclick="add(event)" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="h-6 w-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M12 6v12m6-6H6" />
                  </svg>
                  <span id="${menu.menuId}" key="${menu.menuNama}" harga="${menu.menuHarga}">0</span>
                  <svg id="${menu.menuId}" onclick="sub(event)" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="h-6 w-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M18 12H6" />
                  </svg>
                </div>
              </div>
            </div>
            
            </c:forEach>
            
            
          </div>
        </div>
        <div class="w-2/6 p-3 lg:w-3/12 mx-3">
          <h2 class="px-2 text-lg font-bold">Struk</h2>
          <div id="printableArea" class="mt-4 flex flex-col gap-3 rounded-lg p-3 outline outline-1">
            <div class="text-right text-xs">
              <p>Sigma Coffee</p>
              <p id="nama"></p>
              <p id="dateTime"></p>
              <p id="orderId" name="orderId">${orderId}</p>
            </div>
            <div>
              <table class="w-[100%] table-fixed text-right font-mono text-xs">
                <thead><tr class="table-row">
                  <th class="">Nama</th>
                  <th>Jumlah</th>
                  <th>Harga</th>
                </tr>
                </thead>
                
                <tbody id="list-table" class="last:border-b-2 border-b-black ">
                </tbody>
              </table>
              <p id="totalAmount" class="text-xs text-right font-bold"></p>
            </div>
          </div>
          <button onclick="orderHandler()" class="mt-3 w-[100%] rounded bg-[#A27B5C] p-2 font-bold text-white">Order</button>
        </div>
      </div>
    </main>
  </body>
</html>

