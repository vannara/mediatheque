<!--
  Copyright (c) 2010, Oracle. All rights reserved.

  Redistribution and use in source and binary forms, with or without
  modification, are permitted provided that the following conditions are met:

  * Redistributions of source code must retain the above copyright notice,
    this list of conditions and the following disclaimer.

  * Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

  * Neither the name of Oracle nor the names of its contributors
    may be used to endorse or promote products derived from this software without
    specific prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
  THE POSSIBILITY OF SUCH DAMAGE.
-->
<%-- 
    Document   : ListAdherents
    Created on : 13 nov. 2013, 12:12:02
    Author     : user
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Adherent</title>
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
    </head>
    <script>
        function deleteAdherent(id) {
            alert(id);
        }

        function editAdherent(id) {
            alert(id);
        }

        function addAdherent() {
            window.location = "CreateAdherent.jsp";
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
                            <li><a href="#">Adherent</a></li>
                            <li><a href="#">User</a></li>                    
                        </ul>
                    </li>                
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
    </nav>
    <br> <br> 
    <h1 class="text-center">List of Adherents</h1>
    <br>
    <br> <br>
    <table id="cateListTable" class="table table-hover">
        <tr >
            <th class="span2"></th>
            <th class="span2">ID</th>
            <th class="span2">Name</th>
            <th class="span2">First Name</th>
            <th class="span2">Birthday</th>
            <th class="span2">Registered Date</th>
            <!--<th class="span2">Number of borrow</th>-->
        </tr>
        <c:forEach var="adherent" begin="0" items="${requestScope.adherentList}">
            <tr>
                <td class="span2 no-margin-left"><button class="span1 no-margin-left btn-primary" onclick="editAdherent('${adherent.adherentId}')">Edit</button>
                    <button class="span1 no-margin-left btn-danger" onclick="deleteAdherent('${adherent.adherentId}')">Delete</button>
                </td>
                <td class="span2">${adherent.adherentId}&nbsp;&nbsp;</td> 
                <td class="span2">${adherent.lastName}&nbsp;&nbsp;</td> 
                <td class="span2">${adherent.firstName}&nbsp;&nbsp;</td> 
                <td class="span2">${adherent.dateofBirth}&nbsp;&nbsp;</td> 
                <td class="span2">${adherent.dateAdhesion}&nbsp;&nbsp;</td>
            </tr> 

        </c:forEach>

    </table>
    <div><br><br></div>
    <button class="span2 btn-primary" onclick="addAdherent()">Create a new adherent</button>
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
