<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="resources/css/waitinglist.css" />
<script src="resources/javascript/waitinglist.js"></script>
</head>

  <body onload="loadHandler()">
    
    <c:forEach items="${allList}" var="list">
    
    <div class="m-2 min-h-fit w-64">
      <div class="bg-[#2C3639] rounded-t-md border-b-2 border-b-[#A27B5C] p-2 text-right text-sm text-white">
        <h1>Order No <span>#01</span></h1>
        <p>Name : <span>${list.customerName}</span></p>
        <p>ID : <span>${list.orderId}</span></p>
        <p>Time : <span>${list.orderDate}</span></p>
      </div>

      <div class="bg-[#DCD7C9] px-2 py-4 rounded-b-md">
        <h1 class=" font-bold">Orders :</h1>
        <table class="table w-full table-auto text-center text-sm">
          <thead class="font-bold">
            <tr>
              <td>Item</td>
              <td>Amount</td>
            </tr>
          </thead>

          <tbody id="table-body" data="${list.orderList}">
            <tr>
              <td>Cappucino</td>
              <td>x1</td>
            </tr>
          </tbody>
        </table>

        <div class="mt-5 flex w-full justify-center">
          <button class="rounded-full bg-lime-400 px-3 py-2 font-bold text-white">Complete</button>
        </div>
      </div>
    </div>
    
    </c:forEach>
    
  </body>
</html>

