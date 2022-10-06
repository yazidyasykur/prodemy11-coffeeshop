<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%
	request.setAttribute("contextName",request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="resources/css/daftarmenu.css" />
	<script src="resources/javascript/daftarmenu.js"></script>
    <title>Daftar Menu</title>
</head>

<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-amber-800" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-coffee me-2"></i>Sigma Coffee Shop</div>
            <div class="list-group list-group-flush my-3">
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-chart-line me-2"></i>Statistics</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-paperclip me-2"></i>Daftar Menu</a>          
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div class="bg-orange-700 w-full" id="">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id=""></i>
                    <h2 class="fs-2 m-0">Daftar Menu</h2>
                </div>
            </nav>

            <div class="container-fluid px-4">
              <div class="grid grid-cols-1 gap-4  ">
              <c:forEach items="${allMenu}" var="menu">
                <div class="">                  
                    <div class="">
                        <div id="${menu.menuId}" class="hover:opacity-95 px-30 bg-white shadow-sm d-flex rounded relative">
                            <div class="my-2 mx-2">
                                <img class="rounded-xl w-28 lg:w-40" src="${menu.menuGambar}">
                            </div>
                            <div class="my-4 mx-2">
                              <h1>${menu.menuNama}</h2>
                              <p>Rp. ${menu.menuHarga}</p>
                              <p>${menu.menuDeskripsi}</p>
                            </div> 
                            <div id="act" class= "gap-3 flex absolute bottom-0 right-0 mr-3 mb-2 items-center" >
                              <div class="w-6 opacity-30 hover:opacity-100 hover:cursor-pointer hover:text-clip">
                              <a href="${contextName}/edit?id=${menu.menuId}" onclick="document.getElementById('authentication-modal').classList.remove('hidden')">
                           <svg  xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                              <path d="M373.1 24.97C401.2-3.147 446.8-3.147 474.9 24.97L487 37.09C515.1 65.21 515.1 110.8 487 138.9L289.8 336.2C281.1 344.8 270.4 351.1 258.6 354.5L158.6 383.1C150.2 385.5 141.2 383.1 135 376.1C128.9 370.8 126.5 361.8 128.9 353.4L157.5 253.4C160.9 241.6 167.2 230.9 175.8 222.2L373.1 24.97zM440.1 58.91C431.6 49.54 416.4 49.54 407 58.91L377.9 88L424 134.1L453.1 104.1C462.5 95.6 462.5 80.4 453.1 71.03L440.1 58.91zM203.7 266.6L186.9 325.1L245.4 308.3C249.4 307.2 252.9 305.1 255.8 302.2L390.1 168L344 121.9L209.8 256.2C206.9 259.1 204.8 262.6 203.7 266.6zM200 64C213.3 64 224 74.75 224 88C224 101.3 213.3 112 200 112H88C65.91 112 48 129.9 48 152V424C48 446.1 65.91 464 88 464H360C382.1 464 400 446.1 400 424V312C400 298.7 410.7 288 424 288C437.3 288 448 298.7 448 312V424C448 472.6 408.6 512 360 512H88C39.4 512 0 472.6 0 424V152C0 103.4 39.4 64 88 64H200z"/></svg>
                              </a>
                              </div>
                        
                              <div class="w-5 opacity-30 hover:cursor-pointer hover:opacity-100"><a href="<c:url value='/remove/${menu.menuId}'/>">
                           <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M135.2 17.7C140.6 6.8 151.7 0 163.8 0H284.2c12.1 0 23.2 6.8 28.6 17.7L320 32h96c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 96 0 81.7 0 64S14.3 32 32 32h96l7.2-14.3zM32 128H416V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V128zm96 64c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16z"/></svg>
                              </a>
                              </div>
                            </div>                          
                        </div>
                    </div> 
                </div>      
              </c:forEach>
              <!--tambah menu-->
         
              <button type="button" onclick="document.getElementById('authentication-modal').classList.remove('hidden')">
                    <div class="g-3 my-2 hover:cursor-pointer hover:opacity-90 position-relative">                  
                    <div>
                        <div class=" px-30 bg-white shadow-sm flex justify-center rounded">
                          <div >
                            <div class="mt-2.5 float-left w-7 bg-green-500 rounded-md p-1">
                             <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/></svg>
                            </div>
                               <div class="mx-5 my-1.5">
                                <h2>Tambah menu</h2>
                               </div>
                          </div>
                                                 
                        </div>
                    </div> 
                </div> 
           </button>

     <div id="authentication-modal" tabindex="-1" aria-hidden="true"  class="hidden overflow-y-auto overflow-x-hidden absolute lg:left-56 top-0 z-50 w-2/3  md:h-full">
    		<div class="relative p-4 ">
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white"  onclick="document.getElementById('authentication-modal').classList.add('hidden')" >
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="py-6 px-6 lg:px-8 overflow-hidden">
                <h3 class="mb-4 text-xl font-medium text-gray-900">Tambahkan menu baru ! </h3>
                
				
                <form method="post" action="${contextName}/mns" id="menu-form" class="space-y-6">
                    <div class="flex flex-col">
                    <table>
                      <input type="hidden" name="mode" value="tambah">
                
                      <tr>
                      <td><label class="mr-4" value="">Menu Id </label></td>
                      <td class='w-full'><input name="menuId" id="menuId" value="" type="text" class="border border-black p-2 text-sm w-9/12 rounded-lg" placeholder="Nama Menu"></td>
                      </tr>
                      
                      <tr>
                      <td><label name="menuNama" class="mr-4">Nama menu </label></td>
                      <td><input name="menuNama" value="" id="menuNama" type="text" class="border border-black p-2 text-sm w-9/12 rounded-lg" placeholder="Nama Menu"></td>
                      </tr>
                      
                     <tr>
                     <td><label name="menuTipe" class="mr-6">Jenis menu </label></td>
                     <td><input name="menuTipe" value="" id="menuJenis" type="text" class="border border-black p-2 text-sm w-9/12 rounded-lg" placeholder="Makanan / Minuman"></td>
                     </tr>
                     
                   	<tr>
                   	<td><label name="menuGambar" class="mr-12">Gambar</label></td>
                    <td><input name="menuGambar" value="" id="menuGambar" type="text" class="border border-black p-2 text-sm w-9/12 rounded-lg" placeholder="Gambar"></td>
                    </tr>
                    
                 	<tr>
                 	<td><label name="menuDeskripsi" class="mr-10">Deskripsi </label></td>
                    <td><input name="menuDeskripsi"  value="" id="menuDeskripsi" type="text" class="border border-black p-2 text-sm w-9/12 rounded-lg" placeholder="Komposisi"></td>
                    </tr>
                    
                   <tr>
                 	<td><label name="menuHarga" class="mr-10">Harga menu </label></td>
                    <td><input name="menuHarga"  value="" id="menuHarga" type="text" class="border border-black p-2 text-sm w-9/12 rounded-lg" placeholder="Harga"></td>
                   </tr>
                   
                   <tr>
                      
                   </tr>
                   </table>
                   <button type="button" class="w-full text-white bg-amber-600 hover:bg-amber-800 focus:ring-4 focus:outline-none focus:ring-amber-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center" onclick="submitHandler()">
                        Tambah Menu</button>
                    </div>
                </form>
                
            </div>
        </div>
    </div>
</div> 

              </div>        
                </div>

  
            </div>
        </div>
    </div>
    </div>
</body>

</html>