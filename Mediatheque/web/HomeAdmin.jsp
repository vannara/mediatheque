<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mediathèque</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="bootstrap/css/logo-nav.css" rel="stylesheet">

  </head>

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
                                    <li><a href="CreateAdherent">Create a new adherent</a></li>
                                    <li><a href="ListAdherents">List adherent</a></li> 
                                 </ul>       
                    </li>
            <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <b> Configuration</b>                     
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Oeuvre</a></li>
                        <li><a href="ListCategories">Category</a></li>
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

    <div class="container">

      <div class="row">
        <div class="col-lg-12">
          <h1>A custom navigation with a logo and faux centered menu items.</h1>
          <p>The image size is 150x75 pixels. If you change the logo size, or if you change the font of the menu items, you will need to re-center the menu items in <code>logo-nav.css</code>.</p>
        </div>
      </div>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- Make sure to add jQuery - download the most recent version at http://jquery.com/ -->
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
  </body>
</html>