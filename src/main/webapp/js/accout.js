
function login(){

    var username = $("#username").val();
    var pwd = $("#pwd").val();
    pwd = $.md5(pwd);

    $.post('loginCheck', {username:username, password:pwd}, function(result){
      if (result.status == 1) {

        location.href="index"

      }else{
           alert(result.msg)
      }
      
      console.log(result.msg)

    }, 'json');



  }


  $("#pwd").keyup(function(event){
    if(event.keyCode == 13){
      $("#btnLogin").click();
    }
  });
