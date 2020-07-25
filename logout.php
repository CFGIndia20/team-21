<?php 
session_start();
session_destroy();
$_SESSION['sid']=NULL ;
header("Location: login.php");



 ?>