<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 16/4/7
  Time: 上午10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>wangEditor2 test</title>
  <link rel="stylesheet" type="text/css" href="./websrc/dist/css/wangEditor.min.css">
  <style type="text/css">
    #editor-trigger {
      height: 300px;
      max-height: 400px;
    }
    .container {
      width: 100%;
      margin: 0 auto;
      position: relative;
    }
  </style>
</head>
<body style="padding:0 20px;">
<div id="editor-container" class="container">
  <div id="editor-trigger">
    <p>请输入内容...</p>
  </div>
  <!-- <textarea id="editor-trigger" style="display:none;">
      <p>请输入内容...</p>
  </textarea> -->
</div>
<button id="getrow">获取编辑框内容</button>
<p><br></p>

<script type="text/javascript" src="./websrc/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./websrc/dist/js/wangEditor.js"></script>
<!--<script type="text/javascript" src="../dist/js/wangEditor.min.js"></script>-->
<script type="text/javascript">
  // 阻止输出log
  // wangEditor.config.printLog = false;

  var editor = new wangEditor('editor-trigger');

  // 上传图片
  editor.config.uploadImgUrl = '/servlet/UploadHandleServlet';

  // 表情显示项
  editor.config.emotionsShow = 'value';

  // 跨域上传
  // editor.config.uploadImgUrl = 'http://localhost:8012/upload';

  // 第三方上传
  // editor.config.customUpload = true;

  // editor.config.menus = [
  //     'img',
  //     'insertcode',
  //     'eraser',
  //     'fullscreen'
  // ];

  // onchange 事件
  editor.onchange = function () {
    console.log(this.$txt.html());
  };

  // 取消过滤js
  // editor.config.jsFilter = false;

  // 取消粘贴过来
  // editor.config.pasteFilter = false;

  // 设置 z-index
  // editor.config.zindex = 20000;

  // 语言
  // editor.config.lang = wangEditor.langs['en'];
  // 自定义菜单
  editor.config.menus = [
    'source',
    '|',
    'bold',
    'underline',
    '|',
    'quote',
    'fontfamily',
    'fontsize',
    'alignleft',
    'aligncenter',
    'alignright',
    '|',
    'img'
  ];
  // 自定义菜单UI
  editor.UI.menus.bold = {
    normal: '<button style="font-size:20px; margin-top:5px;">B</button>',
    selected: '.selected'
  };
  editor.UI.menus.italic = {
    normal: '<button style="font-size:20px; margin-top:5px;">I</button>',
    selected: '<button style="font-size:20px; margin-top:5px;"><i>I</i></button>'
  };
  editor.create();
</script>
<script>
  $('#getrow').click(function () {
    // 获取编辑器区域完整html代码
    var html = editor.$txt.html();
    alert(html);
  });
</script>
</body>
</html>