<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>主页</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>

        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/welcomePage",
                    type: 'POST',
                    data: {'userId': $("#userId").val(), 'role': $("input[name='role']:checked").val()},
                    success: function (data) {
                        if(data=="success"){
                            window.location.href='game'
                        }
                        alert(data);
                    }
                });
            })
        });

    </script>
</head>
<body>
<h2>请选择角色和输入用户ID</h2>
用户ID<input id="userId" type="text"/>
<li class="questionType"><span>角色</span>
    <ul class="radio">
        <li><label for="radio"><input type="radio" name="role" id="radio" value="魔法师">魔法师</label>
        </li>
        <li><label for="radio"><input type="radio" name="role" id="radio1" value="治疗师">治疗师</label>
        </li>
        <li><label for="radio"><input type="radio" name="oler" id="radio2" value="射手">射手</label>
        </li>
    </ul>
</li>

<%--<input id="role" type="text"/>--%>
<input id="submit" type="submit" value="提交"/>
</body>
</html>
