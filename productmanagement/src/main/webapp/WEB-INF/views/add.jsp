<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

 <div class="container" >

    <!-- Login Form -->
    <form action="./add" method="get" >
    <img class="mb-4" src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Add Product</h1>

    <div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="Enter the  Product Id" name="pid">
      <label for="floatingInput">Product Id</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Enter the  Product Name" name="pname">
      <label for="floatingInput">Product Name</label>
    </div>
    <div class="form-floating">
      <input type="date" class="form-control" id="floatingInput" placeholder="Enter the  Product Manufacture Date" name="mfd">
      <label for="floatingInput">Manufacture Date</label>
    </div>
    <div class="form-floating">
      <input type="date" class="form-control" id="floatingInput" placeholder="Enter the  Product Expiry Date" name="exp">
      <label for="floatingInput">Expiry Date</label>
    </div>
    <div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="Enter the  Product Price" name="price">
      <label for="floatingInput">Product Price</label>
    </div>
    <div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="Enter the  Product Quantity" name="quant">
      <label for="floatingInput">Product Quantity</label>
    </div>
    

    
    <button class="w-100 btn btn-lg btn-primary" type="submit">Add</button>
    
  </form>




<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>