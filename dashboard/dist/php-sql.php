<?php 
session_start();

?>

<?php 
  
$con=mysqli_connect('localhost','root') ;
mysqli_select_db($con,'hostel') ;
$q="select * from student where student.sid=123" ;
$res=mysqli_query($con,$q);
$arr=mysqli_fetch_array($res);
$num=mysqli_num_rows($res) ;

  echo $arr["roomid"] ;?>
  <!DOCTYPE html>
  <html>
  <head>
  	<title>
  		HII
  	</title>
  </head>
  <body>
  
  </body>
  </html>