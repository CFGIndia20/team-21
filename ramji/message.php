<?php
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
 $useq1=$_POST["desc"];
 $useq2=$_POST["empId"];
 $useq3=$_POST["encodedImage"];   
 $que=select * from test;
 $result1=mysqli_query($conn,$que);

 $num=mysqli_num_rows($result1) ;
 $z=array();
for($i=1;$i<=num;$i++)
{
	
  $x=["desc"=>$useq1,"empId"=>$useq2,"encodedImage"=>$useq3];
  array_push($z,$x);	
}
 if ($conn->query($que) == TRUE) {
    
     header('Content-type:application/json');
     $re=json_encode($z);
     echo $re;
} 
?>


