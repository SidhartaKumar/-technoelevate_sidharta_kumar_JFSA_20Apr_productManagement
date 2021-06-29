<%@page import="com.te.productmanagement.beans.ProductInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <% String msg=(String) request.getAttribute("msg"); 
    ProductInfoBean infoBean = (ProductInfoBean) request.getAttribute("id");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form>
    <img class="mb-4" src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Update Product</h1>

    <div class="form-group">
			<label>Product ID</label> <%=infoBean.getPid() %> <input type="hidden" class="form-control"
				name="pid" placeholder="Enter Product ID" value=<%=infoBean.getPid() %>>
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
    

    
    <button class="w-100 btn btn-lg btn-primary" type="submit">Update</button>
    
  </form>


</body>
</html>