<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title></title>
 <link rel="icon" href="../images/favicon.ico">
  <link rel="stylesheet" type="text/css" href="../css/login.css">
  <script type="text/javascript" src="../js/plugins/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="../js/plugins/easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="../js/jquery.md5.js"></script>
   <script type="text/javascript" src="../js/accout.js"></script>

<div class="login_wrap">
  <div style="overflow: hidden;height:100%;display: block;">
    <div style="width: 680px; height: 100px; margin-left:auto;margin-right: auto; margin-top: 180px;background:url('../images/login_logo.png') top center no-repeat;">
    </div>
    <div style="margin-left:auto;margin-right: auto;margin-top: 30px;">
      <form id="login2" method="post">
        <label>用户名：<input id="username" type="text" name="userName"/></label>
        <label style="margin-top: 20px;">密　码：<input id="pwd" type="password" name="pass"/></label>
        <button id="btnLogin" type="button" onclick="javascript:login();">登　录</button>
      </form>
    </div>
  </div>
</div>
</html>