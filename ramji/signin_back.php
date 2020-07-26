<?php
 $useq1=$_POST["email"];
 $useq3=$_POST["password"];
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
  $qer="SELECT *from volunteer";
  $result=mysqli_query($conn,$qer);
  $qert="SELECT *from employee";
  $result1=mysqli_query($conn,$qert);
  $num=mysqli_num_rows($result) ;
  for($i=0;$i<$num;$i++)
  {
    $rew=mysqli_fetch_assoc($result1);
    $rew1=mysqli_fetch_assoc($result);
    if($rew["WID"]==$useq1)
    {
      if($rew["WPASS"]==$useq3)
       {
         $r=["email"=>"$rew["WID"],"Type"=>"Employee"];
        header('Content-type:application/json');
        $re=json_encode($r);
        echo $re;
        exit();
       }
       else
       {
         $r=["email"=>"$rew["WID"],"Type"=>"failure"];
         header('Content-type:application/json');
         $re=json_encode($r);
         echo $re;
         exit();
       }
    }
    elseif($rew1["VID"]==$useq1)
    {
      
     if($rew1["VPASS"]==$useq3)
       {
         $r=["email"=>"$rew["VID"],"Type"=>"Volunteer"];
        header('Content-type:application/json');
        $re=json_encode($r);
        echo $re;
        exit();
       }
       else
       {
         $r=["email"=>"$rew["VID"],"Type"=>"failure"];
         header('Content-type:application/json');
         $re=json_encode($r);
         echo $re;
         exit();
       }
    }

  }
$r=["email"=>"0,"Type"=>"0"];
         header('Content-type:application/json');
         $re=json_encode($r);
         echo $re;
         
$conn->close();
?>