<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
	
<head>
	<link rel="stylesheet" href="resources/css/customer.css">
</head>

  <body class="">
    <header>
      <nav class="flex items-center justify-between bg-[#2C3639] p-3 outline outline-4 outline-[#A27B5C]">
        <p class="font-semibold text-white">Sigmaka Coffee</p>
        <button class="rounded-lg p-2 text-white outline outline-1">Login</button>
      </nav>
    </header>
    <main class="m-3">
      <div class="flex gap-2.5">
        <div class="w-4/6 lg:w-9/12">
          <h2 class="px-2 text-lg font-bold">Menu</h2>
          <div class="flex max-h-fit flex-col gap-3 overflow-y-auto p-3">
            <div class="relative flex gap-2 rounded pr-2 shadow-md shadow-slate-600 outline outline-1">
              <img src="https://images.unsplash.com/photo-1623859763838-a304cbfd4901?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80" class="w-40 lg:w-52" />
              <div class="flex max-h-36 flex-col py-2">
                <h2 class="mb-2 font-semibold">Americano</h2>
                <p class="mb-5 overflow-y-auto text-xs lg:text-sm">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                <div class="lg:text-md absolute right-3 bottom-3 flex w-fit gap-3 justify-self-end rounded outline outline-1">
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="h-6 w-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M12 6v12m6-6H6" />
                  </svg>
                  <span>1</span>
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="h-6 w-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M18 12H6" />
                  </svg>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="w-2/6 lg:w-3/12">
          <h2 class="px-2 text-lg font-bold">Struk</h2>
          <div class="mt-3 flex flex-col gap-3 rounded-lg p-3 outline outline-1">
            <div class="text-right text-xs">
              <p>Sigmaka Coffee</p>
              <p>Monday, 03/10/2022, 12:02:03 WIB</p>
              <p>Order ID : 123e4567-e89b-12d3-a456</p>
            </div>
            <div>
              <table class="w-[100%] table-fixed text-right font-mono text-xs">
                <tr class="table-row">
                  <th class="">Nama</th>
                  <th>Jumlah</th>
                  <th>Harga</th>
                </tr>

                <tr>
                  <td>Americano</td>
                  <td>x1</td>
                  <td>17.000</td>
                </tr>

                <tr>
                  <td>Espresso</td>
                  <td>x1</td>
                  <td>17.000</td>
                </tr>

                <tr>
                  <td>Cappucino</td>
                  <td>x1</td>
                  <td>17.000</td>
                </tr>
              </table>
            </div>
          </div>
          <button class="mt-3 w-[100%] rounded bg-[#A27B5C] p-2 font-bold text-white">Order</button>
        </div>
      </div>
    </main>
  </body>
</html>
