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
 $as=$_POST["id"];
 $que="UPDATE  q set verify=1 where id=$as";
 $r="select * from q where id=$as"; 
 $result=mysqli_query($conn,$r);
 $row=mysqli_fetch_array($result) ;  
$x=["desc"=>$row['desc'],"empId"=>$row['empId'],"encodedImage"=>$row['encodedImage'],"verify"=>$row['verify'],"id"=>$row['id']];	

     header('Content-type:application/json');
     $re=json_encode($x);
     echo $re;

?>


