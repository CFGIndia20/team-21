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
 $userq1=$_POST["desc"];
 $userq2=$_POST["empId"];
 $userq3=$_POST["encodedImage"]; 
 $userq4=$_POST["verify"];
 $quer="insert into q values('$useq1','$userq2','$userq3','$userq4')";
 if ($conn->query($quer) == TRUE) {
    $x=["desc"=>$userq1,"empId"=>$userq2,"encodedImage"=>$userq3,"verify"=>$userq4];
     header('Content-type:application/json');
     $re=json_encode($x);
     echo $re;
}
echo 0;
?>


