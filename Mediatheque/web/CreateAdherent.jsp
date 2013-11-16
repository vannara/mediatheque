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
            window.close();
        }
        
        function createCategory() {
            boolean isOk=false;
            var lastN=$("#lastName").val()
           
            if(isOk){
                document.forms['createAdherentForm'].submit();
            }
        }

        function SaveNew() {
            verifForm();
            createAdherent();
            ClearForm();
        }

        function SaveClose() {
            createAdherent();
            goback();
        }

        function ClearForm() {
            $("#lastName").val("");
            $("#firstName").val("");
            $("#dateofBirth").val("");
            $("#registeredDate").val("");
            $("#city").val("");
            $("#postalcode").val("");
            $("#street").val("");
            $("#guaranteeAmt").val("");
            $("#annualFee").val("");
        }
        function verifForm(f){
             var lastNameOk=verification(f.lastName);
             var firstNameOk=verification(f.firstName);
             var birthOk=CheckDate(f.dateofBirth);
             var adhesionOk=CheckDate(f.registeredDate);
             var cityOk = verification(f.city);
             var codeOk=verificationInteger(f.postalcode);
             var streetOk=verification(f.street);
             var montantOk=verificationInteger(f.guaranteeAmt);
             var annualfeeOk=verificationInteger(f.annualFee);
             if(lastNameOk && firstNameOk && birthOk && adhesionOk && cityOk && codeOk && streetOk && montantOk && annualfeeOk)
8                return true;
9            else
10              {
11              alert("Please enter all parameters!");
12              return false;
13              }
        }
        function verificationInteger(){
                var recup=parseDouble(champ.value);
                if(isNaN(recup)){
                    surligne(champ, true);
6                   return false;
                }
                else
9               {
10                  surligne(champ, false);
11                  return true;
12              }
            }
        }
        function verification(champ,type)
2       {   var regex =champ.value;
3           if(regex.test(""))
4           {
5               surligne(champ, true);
6               return false;
7           }
8            else
9           {
10              surligne(champ, false);
11              return true;
12          }
13      }
        function surligne(champ, erreur)
2       {   if(erreur)
4               champ.style.backgroundColor = "#fba";
5           else
6               champ.style.backgroundColor = "";
7       }
      function CheckDate(d) {
      // Cette fonction vérifie le format JJ/MM/AAAA saisi et la validité de la date.
      // Le séparateur est défini dans la variable separateur
      var amin=1910; // année mini
      var amax=2013; // année maxi
      var separateur="/"; // separateur entre jour/mois/annee
      var j=(d.substring(0,2));
      var m=(d.substring(3,5));
      var a=(d.substring(6));
      var ok=1;
      if ( ((isNaN(j))||(j<1)||(j>31)) && (ok==1) ) {
         alert("day is not correct."); ok=0;
      }
      if ( ((isNaN(m))||(m<1)||(m>12)) && (ok==1) ) {
         alert("month is not correct."); ok=0;
      }
      if ( ((isNaN(a))||(a<amin)||(a>amax)) && (ok==1) ) {
         alert("year is not correct."); ok=0;
      }
      if ( ((d.substring(2,3)!=separateur)||(d.substring(5,6)!=separateur)) && (ok==1) ) {
         alert("you should write the date dd/mm/YYYY with : "+separateur); ok=0;
      }
      if (ok==1) {
         var d2=new Date(a,m-1,j);
         j2=d2.getDate();
         m2=d2.getMonth()+1;
         a2=d2.getFullYear();
         if (a2<=100) {a2=1900+a2}
         if ( (j!=j2)||(m!=m2)||(a!=a2) ) {
            alert("the date "+d+" doesn't exist !");
            ok=0;
         }
      }
      return ok;
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
                             <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Manage Adherent</b></a>
                                 <ul class="dropdown-menu">
                                    <li><a href="CreateAdherent.jsp">Create a new adherent</a></li>
                                    <li><a href="ListAdherents.jsp">List adherent</a></li> 
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
                    <form id="createAdherentForm" onsubmit="return verifForm(this)" action="CreateAdherent" method="post" class="span6">
                        <h2> Adherent Information</h2>
                        <table>
                            <tr><td>Last Name</td><td><input type="text" id = "lastName" onblur="verification(this)" name="lastName" /></td></tr>
                            <tr><td>Fist Name</td><td><input type="text" id = "firstName" onblur="verification(this)" name="firstName" /></td></tr>
                            <tr><td>Birthday</td><td><input type="date" id = "dateofBirth" onblur="CheckDate(this)" name="dateofBirth" /></td></tr>
                            <tr><td>Registration Date</td><td><input type="date" id = "registeredDate" onblur="CheckDate(this)" name="registeredDate" /></td></tr>
                        </table>
                        <hr>
                        <h2> Adherent Address</h2>
                        <table>
                            <tr><td>City</td><td><input type="text" id = "city" onblur="verification(this)" name="city" /></td></tr>
                            <tr><td>Postal Code</td><td><input type="text" id = "postalcode" onblur="verificationInteger(this)" name="postalcode" /></td></tr>
                            <tr><td>Street</td><td><input type="text" id = "street" onblur="verification(this)" name="street" /></td></tr>
                        </table>
                        <h2> Card information</h2>
                        <table>
                            <tr><td>Guarantee Amount</td><td><input type="text" onblur="verificationInteger(this) "id = "guaranteeAmt" name="guaranteeAmt" /></td></tr>
                            <tr><td>Annual Fee</td><td><input type="text" id = "annualFee" onblur="verificationInteger(this)" name="annualFee" /></td></tr>
                        </table>
                        <br>
                        <button class="btn-primary" onclick="SaveNew()" id="btnSaveNew">Save & New</button>
                        <button class="btn-primary" id="SaveClose" onclick="SaveClose();">Save & Close </button>
                        <button class="btn-primary" onclick="goback()">See All Adherent</button>
                    </form>
             <br><br>
    </div>
      </div>
</div>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>