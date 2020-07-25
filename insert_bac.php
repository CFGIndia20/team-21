<?php
 $useq1=$_POST["email"];
 $useq2=$_POST["fullname"];
 $useq3=$_POST["password"];
 $useq4=$_POST["age"];
 $useq5=$_POST["community"];
 $useq6=$_POST["phone"];
 $host = 'fdb29.awardspace.net';
 $user = '3520158_umeed';
 $pass = 'ramjireddy1';
 $database = '3520158_umeed';
  
	$conn = mysqli_connect($host, $user, $pass, $database);

	if (!$conn) 
	{
    	die('database not connected!');
	} 
	else 
	{
    	mysqli_select_db($conn,$database);
    	}
      
       $que="insert into employee values('$useq1','$useq3','$useq6','$useq2','$useq4','$useq5')";
     
 if ($conn->query($que) == TRUE) {
    
    echo 1;
} 


$conn->close();
?>