<%--
  Created by IntelliJ IDEA.
  User: dell pc
  Date: 2020/10/4
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td align="center" colspan="8">
            <h2>商品详细信息列表</h2>
        </td>
    </tr>
    <tr align="center">
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>库存数量</td>
        <td>订单状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${pageInfo}" var="item">
        <tr align="center">
            <td>${item.id}</td>
            <td>${item.goodsname}</td>
            <td>${item.goodsprice}</td>
            <td>${item.goodscount}</td>
            <td>
                <c:if test="${item.billstatus==0}">
                    待处理
                </c:if>
                <c:if test="${item.billstatus==1}">
                    处理中
                </c:if>
                <c:if test="${item.billstatus==2}">
                    已处理
                </c:if>
            </td>
            <td><a href="/upd?id=${item.id }">修改</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
