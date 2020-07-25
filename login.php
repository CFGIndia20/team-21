<?php 
session_start();
if(isset($_SESSION['sid']))
{
    header("Location: index1.php");
}

 ?>



<!DOCTYPE html> 
<html> 
<style> 
    /*set border to the form*/ 
      
    form { 
        border: 3px solid #ff9fff; 
    } 
    /*assign full width inputs*/ 
      
    input[type=text], 
    input[type=password] { 
        width: 100%; 
        padding: 12px 20px; 
        margin: 8px 0; 
        display: inline-block; 
        border: 1px solid #ccc; 
        box-sizing: border-box; 
    } 
    /*set a style for the buttons*/ 
      
    button { 
        background-color:#911686; 
        color:black; 
        padding: 14px 20px; 
        margin: 8px 0; 
        border: none; 
        cursor: pointer; 
        width: 100%; 
    } 
    /* set a hover effect for the button*/ 
      
    button:hover { 
        opacity: 0.8; 
    } 
    /*set extra style for the cancel button*/ 
      
    .cancelbtn { 
        width: auto; 
        padding: 10px 18px; 
        background-color: #911686; 
    } 
    /*centre the display image inside the container*/ 
      
    .imgcontainer { 
        text-align: center; 
        margin: 10px 0 6px 0; 
    } 
    /*set image properties*/ 
      
    img.avatar { 
        width: 40%; 
        border-radius: 50%; 
    } 
    /*set padding to the container*/ 
      
    .container { 
        padding: 16px; 
        background-color: #ff9fff;
    } 
    /*set the forgot password text*/ 
      
    span.psw { 
        float: right; 
        padding-top: 16px; 
    } 
    /*set styles for span and cancel button on small screens*/ 
      
    @media screen and (max-width: 300px) { 
        span.psw { 
            display: block; 
            float: none; 
        } 
        .cancelbtn { 
            width: 100%; 
        } 
    } 
</style> 
  
<body> 
  
    <h2>Login!</h2> 
    <!--Step 1 : Adding HTML-->
    <FORM action="validation.php" method="post" >
    <!--Ananya Add your code!!!-->
        <div class="imgcontainer"> 
            <img src= "umeed-logo.jpeg" alt="Avatar" class="avatar"> 
        </div> 
  
        <div class="container"> 
            <label><b>Username</b></label> 
            <input type="text" placeholder="Enter Username" name="sid" required> 
  
            <label><b>Password</b></label> 
            <input type="password" placeholder="Enter Password" name="password" required> 
  
            <button type="submit">Login</button> 
            <input type="checkbox" checked="checked"> Remember me 
        </div> 
  
        <div class="container" style="background-color:#ff9fff"> 
            <button type="button" class="cancelbtn">Cancel</button>  
            <
        </div> 
    </form> 
  
</body> 
  
</html> 