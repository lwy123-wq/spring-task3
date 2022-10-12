<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>游戏</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>

        function register(){
            $.ajax({
                url: "/gamePage",
                type: 'POST',
                dataType:"json",
                success: function (res) {
                    let list = eval(res);
                    alert(res)
                    console.log(list+"aaaaaaaaaaa")
                },
                error: function (res) {
                    alert("error!!!!!")
                }
            });
        }
        register()

    </script>
</head>
<body>
aaaaaa

</body>
</html>
