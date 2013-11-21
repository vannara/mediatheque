<%-- 
    Document   : ListCategory
    Created on : Nov 03, 2013
    Author     : vannaraloch
--%>
 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Category</title>
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
    </head>
    <script>
        function deleteCategory(id) {
           // alert(id);
            $("#cateId").val(id);
            $.ajax({
               url: "/ListCategories?action=delete&cateId="+ id,
               type: "POST",
               success: function(data) {
                    //If you want to return anything in jsp.
                },
                error: function(jqXHR, textStatus, errorThrown) {
                   // alert("fail");
                }
            });
        }

        function editCategory(id) {
            $("#cateId").val(id);
           // alert(id);
            $.ajax({
               url: "/ListCategories?action=edit&cateId="+ id,
               type: "POST",
               success: function(data) {
                    //If you want to return anything in jsp.
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    //alert("fail" + errorThrown);
                }
            });
        }

        function addCategory() {
            window.location = "CreateCategory.jsp";
        }
    </script>

    <body>

    <nav class="navbar navbar-fixed-top" role="navigation">

        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo-nav"><img src="img/logo1.jpg" width="70%" height="50%"></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="AdminLogin.jsp"><b>Logout</b></a></li>
                    <li><a href="ListBorrows"><b>Borrow</b></a></li>
                    <li><a href="#Return"><b>Return</b></a></li>
                    <li><a href="#Order"><b>Order</b></a></li>
                    <li><a href="#ReceiveDelivery"><b>Receive Order</b></a></li>
                    <li><a href="#Reservation"><b>Reservation</b></a></li> 
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Manage Adherent</b></a>
                        <ul class="dropdown-menu">
                            <li><a href="CreateAdherent">Create a new adherent</a></li>
                            <li><a href="ListAdherents">List adherent</a></li> 
                        </ul>       
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <b> Configuration</b>                     
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="ListOeuvres">Oeuvre</a></li>
                            <li><a href="ListCategories">Category</a></li>
                            <li><a href="ListItems">Item</a></li>
                            <li><a href="ListItemCopies">Item Copy</a></li>
                            <li class="divider"/>
                            <li><a href="ListAdherents">Adherent</a></li>
                            <li><a href="#">User</a></li>                    
                        </ul>
                    </li>                
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
    </nav>
    <br> <br> 
    <h1 class="text-center">List of Categories</h1>
    <br>
    <br> <br>
    <form id="listCategoryForm" action="ListCategories" target="categoryWindow" method="post" class="span12 no-margin-left">
        <table id="cateListTable" class="table table-hover">
            <tr >
                <th class="span2"></th>
                <th class="span1">ID</th>
                <th class="span2">Name</th>
                <th class="span2">Max Borrow Duration</th>
                <th class="span2">Max Borrow Qty</th>
                <th class="span2">Renewable?</th>
            </tr>

            <c:forEach var="cate" begin="0" items="${requestScope.categoryList}">
                <tr>
                    <td class="span2 no-margin-left"><input type="submit" class="span1 no-margin-left btn-primary"  onclick="editCategory('${cate.categoryId}')" name="action" value="Edit"/>
                        <input type="submit" class="span1 no-margin-left btn-danger" onclick="deleteCategory('${cate.categoryId}')" name="action" value="Delete">
                    </td>
                    <td class="span1">${cate.categoryId}&nbsp;&nbsp;</td> 
                    <td class="span2">${cate.categoryName}&nbsp;&nbsp;</td> 
                    <td class="span2">${cate.maxBorrowDuration}&nbsp;&nbsp;</td> 
                    <td class="span2">${cate.maxBorrowQty}&nbsp;&nbsp;</td> 
                    <td class="span2">${cate.isRenewable}&nbsp;&nbsp;</td> 
                </tr> 

            </c:forEach>

        </table>
             <input type="hidden" id="cateId" name="cateId"/>
               
    </form>
    <div><br><br></div>
    <button class="span2 btn-primary" onclick="addCategory()">Add Category</button>
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
