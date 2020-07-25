<?php 
session_start();
$_SESSION['url']=$_SERVER['REQUEST_URI'];
  if(isset($_SESSION['sid'])==0)
  {
    header("Location: login.php");
  }
$id=$_SESSION['sid'];

?>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Umeed</title>
  <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<aside class="side-nav" id="show-side-navigation1">
  <i class="fa fa-bars close-aside hidden-sm hidden-md hidden-lg" data-close="show-side-navigation1"></i>
  <div class="heading">
    <img src="https://drive.google.com/thumbnail?id=1Oq_hQhu7pC-a6CExsBRRWBFvLXyvguXp" alt="">
    <div class="info">
      <h3><a href="#">Udita Chada</a></h3>
     
    </div>
  </div>
  <div class="search">
    <input type="text" placeholder="Type here"><i class="fa fa-search"></i>
  </div>
  <ul class="categories">
    <li><i class="fa fa-home fa-fw" aria-hidden="true"></i><a href="#"> About us</a><br>
      <i class="fa fa-home fa-fw" aria-hidden="true"></i><a href="Logout.php"> Logout</a>
      <ul class="side-nav-dropdown">
        <li><a href="https://umeedforwomen.wixsite.com/umeed/ourteam">Have a look</a></li>
        
      </ul>
    </li>
   
    
   
    
    
    
  </ul>
</aside>
<section id="contents">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <i class="fa fa-align-right"></i>
        </button>
        <a class="navbar-brand" href="#">my<span class="main-color">Dashboard</span></a>
      </div>
      <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          
          <li><a href="#">hi there
            
          </a> </li>
          <li><a href="#"><i data-show="show-side-navigation1" class="fa fa-bars show-side-btn"></i></a></li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="welcome">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="content">
            <h2>Welcome to Umeed</h2>
            <p>Alone we can do little, together We can do so much</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <section class="statistics">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-4">
          <div class="box">
            <i class="fa fa-envelope fa-fw bg-primary"></i>
            <div class="info">
              <h3>
                  <?php 
$con=mysqli_connect('localhost','root');
    mysqli_select_db($con,"mysql");
    $q="select count(WCOMMUNITY) from employee";
    $res=mysqli_query($con,$q);
     
    $row=mysqli_fetch_array($res) ;
  echo $row[0] ;

?>
              </h3> <span>Communities</span>
              <p>communities will be</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="box">
            <i class="fa fa-file fa-fw danger"></i>
            <div class="info">
              <h3>Track</h3> <span>Report</span>
              <p>detailed view of reports</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="box">
            <i class="fa fa-users fa-fw success"></i>
            <div class="info">
              <h3>
                
  <?php 
$con=mysqli_connect('localhost','root');
    mysqli_select_db($con,"mysql");
    $q="select count(WID) from employee";
    $res=mysqli_query($con,$q);
     
    $row=mysqli_fetch_array($res) ;
  echo $row[0] ;

?>

                


              </h3><span>Users</span>
              <p>This shows the number of users</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section class="charts">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-6">
          <div class="chart-container">
            <h3>Yearly progress to see highest sales/production</h3>
            <canvas id="myChart"></canvas>
          </div>
        </div>
        <div class="col-md-6">
          <div class="chart-container">
            <h3>Yearly progress to deduce which product is not that great in performance/demand</h3>
            <canvas id="myChart2"></canvas>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section class="admins">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-6">
          <div class="box">
            <h3>Admins:</h3>
            <div class="admin">
              <div class="img">
                <img class="img-responsive" src="https://drive.google.com/thumbnail?id=1Oq_hQhu7pC-a6CExsBRRWBFvLXyvguXp" alt="admin">
              </div>
              <div class="info">
                <h3>Udita Chada</h3>
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </div>
            <div class="admin">
              <div class="img">
                <img class="img-responsive" src="https://drive.google.com/thumbnail?id=1bW0SsnVAQXSAy2fazT5Vzpm2Mfrtgo3-" alt="admin">
              </div>
              <div class="info">
                <h3>Gauri Mahendra</h3>
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </div>
           
          </div>
        </div>
        <div class="col-md-6">
          <div class="box">
            <h3>Managers:</h3>
            <div class="admin">
              <div class="img">
                <img class="img-responsive" src="https://drive.google.com/thumbnail?id=1KGMZR7PL26JrPm9u2ikAKlijXpRIOUN2" alt="admin">
              </div>
              <div class="info">
                <h3>Megha Khairnar</h3>
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </div>
            
           
          </div>
        </div>
      </div>
      </section>
    <section class='statis text-center'>
      <div class="container-fluid">
        <div class="row">
          
          <div class="col-md-3">
            <div class="box danger">
              <i class="fa fa-user-o"></i>
              <h3>245</h3>
              <p class="lead">User registered</p>
            </div>
          </div>
          <div class="col-md-3">
            <div class="box warning">
              <i class="fa fa-shopping-cart"></i>
              <h3>5,154</h3>
              <p class="lead">Product sales</p>
            </div>
          </div>
          <div class="col-md-3">
            <div class="box success">
              <i class="fa fa-handshake-o"></i>
              <h3>5,154</h3>
              <p class="lead">Transactions</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="chrt3">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-9">
            <div class="chart-container">
              <canvas id="chart3" width="100%"></canvas>
            </div>
          </div>
          <div class="col-md-4">
            <div class="box">
            </div>
          </div>
        </div>
      </div>
    </section>
  </section>
<!-- partial -->
  <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
<script src='https://cdn.jsdelivr.net/npm/chart.js@2.8.0'></script><script  src="./script.js"></script>


</body>
</html>