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

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a new adherent</title>
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
    </head>
    <script type="text/javascript">
        function goback() {
            window.location = "ListAdherents.jsp";
        }

        function createAdherent() {

        }

    </script>
    <body>
        <div>
            <nav class="navbar navbar-fixed-top" role="navigation">

                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
                        <a class="navbar-brand logo-nav"><img src="img/logo1.jpg" width="70%" height="50%"></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="AdminLogin.jsp"><b>Logout</b></a></li>
                            <li><a href="#Borrow"><b>Borrow</b></a></li>
                            <li><a href="#Return"><b>Return</b></a></li>
                            <li><a href="#Order"><b>Order</b></a></li>
                            <li><a href="#ReceiveDelivery"><b>Receive Order</b></a></li>
                            <li><a href="#Reservation"><b>Reservation</b></a></li>
                            <li><a href="#ManageAdherent"><b>Manage Adherent</b></a>
                                 <ul class="dropdown-menu">
                                    <li><a href="#">Create a new adherent</a></li>
                                    <li><a href="#">List adherent</a></li>  
                                 </ul>       
                             </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <b> Configuration</b>                     
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Oeuvre</a></li>
                                    <li><a href="#">Category</a></li>
                                    <li><a href="#">Item</a></li>
                                    <li class="divider"/>
                                    <li><a href="#">Adherent</a></li>
                                    <li><a href="#">User</a></li>                    
                                </ul>
                            </li>                
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav>
        </div>
        <br> 
        <div class="container" >
            <div class="span12"> <h1 class="text-center">Adherent Record</h1>
            </div>
            <div class="span1"><br><br></div>
            <div class="span12">
                <div class="span3"><label></label></div>
                <div class="span5">
                    <form id="createAdherentForm" action="CreateAdherent" method="post" class="span6">
                        <h2> Adherent Information<h2>
                        <table>
                            <tr><td>Last Name</td><td><input type="text" id = "lastName" name="lastName" /></td></tr>
                            <tr><td>Fist Name</td><td><input type="text" id = "firstName" name="firstName" /></td></tr>
                            <tr><td>Birthday</td><td><input type="date" id = "dateofBirth" name="dateofBirth" /></td></tr>
                            <tr><td>Registration Date</td><td><input type="date" id = "registeredDate" name="registeredDate" /></td></tr>
                        </table>
                        <hr>
                        <h2> Adherent Address<h2>
                        <table>
                            <tr><td>City</td><td><input type="text" id = "city" name="city" /></td></tr>
                            <tr><td>Postal Code</td><td><input type="text" id = "postalcode" name="postalcode" /></td></tr>
                            <tr><td>Street</td><td><input type="date" id = "street" name="street" /></td></tr>
                        </table>
                        <h2> Card information<h2>
                        <table>
                            <tr><td>Guarantee Amount</td><td><input type="text" id = "guaranteeAmt" name="guaranteeAmt" /></td></tr>
                            <tr><td>Annual Fee</td><td><input type="text" id = "annualFee" name="annualFee" /></td></tr>
                        </table>
                        <br>
                        <button class="btn-primary" onclick="createAdherent()">Create Adherent</button>
                        <button class="btn-primary" onclick="goback()">Return</button>
                        <input type="submit" id="CreateRecord" value="CreateRecord" class="button" />
                    </form>
     <br><br>
 </div>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>