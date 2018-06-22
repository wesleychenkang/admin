<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName()+":"+8080+path;
  System.out.println(basePath);
%>

<html>
<head>
 <link rel="icon" href="../images/favicon.ico">
    <title>U8Server后台管理系统|U8SDK</title>
  <link rel="icon" href="../images/favicon.ico">
  <link rel="stylesheet" type="text/css" href="../js/plugins/easyui/themes/black/easyui.css">
  <link rel="stylesheet" type="text/css" href="../js/plugins/easyui/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="../js/plugins/easyui/themes/color.css">
  <link rel="stylesheet" type="text/css" href="../css/u8server.css">
  
  <script type="text/javascript" src="../js/plugins/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="../js/plugins/easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="../js/jquery.md5.js"></script>
 
  <script type="text/javascript">
  
  
  /**
   * 创建新选项卡
   * @param tabId    选项卡id
   * @param title    选项卡标题
   * @param url      选项卡远程调用路径
   */
   
   function addTab(tabId,title,url){
	      //如果当前id的tab不存在则创建一个tab

	      if($("#"+tabId).html()!= null){
	        $("#centerTab").tabs("close", title);
	      }

	      var name = 'iframe_'+tabId;
	      $('#centerTab').tabs('add',{
	        title: title,
	        closable:true,
	        cache : false,
	        tools:[
	          {
	            iconCls:'icon-mini-refresh',
	            handler:function(){

	              var tab = $('#centerTab').tabs('getSelected');
	              $('#centerTab').tabs('update', {
	                tab: tab,
	                options: {
	                  title: title,
	                  content: '<iframe name="'+name+'"id="'+tabId+'"src="'+url+'" width="100%" height="100%" frameborder="0" scrolling="auto">'+'</iframe>'
	                }
	              });
	            }
	          }
	        ],
	        //注：使用iframe即可防止同一个页面出现js和css冲突的问题
	        content : '<iframe name="'+name+'"id="'+tabId+'"src="'+url+'" width="100%" height="100%" frameborder="0" scrolling="auto">'+'</iframe>'
	      });

	    }
  
  
   $(function(){
	      $.ajax({
	        type:'POST',
	        dataType:'json',
	        url:'<%=basePath%>/menus/getMyMenus',
	        success:function(data){
	        	console.log(data)
	          $.each(data, function(i, item){

	            var xhtml = '<div title=\"' + item.name + '\"';

	            if(i == 0){
	              xhtml += ' selected=\"true\" '
	            }

	            xhtml += '>';

	            if(item.childMenus){

	              xhtml += '<ul>'
	              $.each(item.childMenus, function(m, c){
	                 xhtml += ' <li style=""><a href=\'javascript:addTab(\"tabId_' + c.id + '\",\"'+ c.name + '\",\"/' + c.path + '\");\'>' + c.name + '</a></li>'
	              });
	              xhtml += '</ul>';
	            }

	            xhtml += '</div>';

	            $("#menus").accordion('add', {
	              title:item.name,
	              content:xhtml
	            });

	          });
	        }
	      })
	    });
  </script>
</head>



<body class="easyui-layout">
  <!-- 正上方panel -->
  <div region="north" style="height:84px" href="<%=basePath%>/header.jsp">
  </div>
  <!-- 正左边panel -->
  <div region="west" title="菜单栏" split="true" style="width:270px;padding1:1px;overflow:hidden;">
    <div id="menus" class="easyui-accordion" fit="true" border="false">
     
    </div>
  </div>
  <!-- 正中间panel -->
  <div region="center" title="功能区" >
    <div class="easyui-tabs" id="centerTab" fit="true" border="false">
      <div title="欢迎页" style="padding:20px;overflow:hidden;">
        <div style="margin-top:20px;">
          <h3>你好，欢迎来到【后台管理系统】</h3>
        </div>
      </div>
    </div>
  </div>
  <!-- 正下方panel -->
  <div region="south" style="height:50px;padding-top: 7px" align="center">
    
  </div>
</body>

</html>