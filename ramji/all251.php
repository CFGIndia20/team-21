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
 $useq1=$_POST["num"]; 
 $que="select * from test";
 $result1=mysqli_query($conn,$que);

 $num=mysqli_num_rows($result1) ;
 $z=array();
for($i=1;$i<=$num;$i++)
{
	
$row=mysqli_fetch_array($result1) ;  

if($i==$useq1){ 
$x=["desc"=>$row['desc'],"empId"=>$row['empId'],"encodedImage"=>$row['encodedImage']];
  array_push($z,$x);	
  exit();
}
}
 if ($conn->query($que) == TRUE) {
    
     header('Content-type:application/json');
     $re=json_encode($z);
     echo $re;
} 
?>


