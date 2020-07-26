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
 $que="select * from WORK";
 $result1=mysqli_query($conn,$que);

 $num=mysqli_num_rows($result1) ;
 $z=array();
for($i=1;$i<=$num;$i++)
{
	
$row=mysqli_fetch_array($result1) ;  
$x=["wname"=>$row['WNAME'],"work"=>$row['WORK'],"Workas"=>$row['Workas'],"Verified"=>$row['verified']];
  array_push($z,$x);	
}
 if ($conn->query($que) == TRUE) {
    
     header('Content-type:application/json');
     $re=json_encode($z);
     echo $re;
} 
?>


