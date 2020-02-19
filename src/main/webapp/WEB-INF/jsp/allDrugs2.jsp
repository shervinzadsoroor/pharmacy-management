<%@ page import="com.shervin.models.Drug" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>home</title>
</head>
<body>
<h3>all drugs</h3>
<div style="display: flex; justify-content: space-around">
    <table class="table">
        <thead>
        <tr>
            <th> Id</th>
            <th> name</th>
            <th> quantity</th>
            <th> price</th>
            <th> description</th>
            <th> code</th>
        </tr>
        </thead>

        <tbody>
        <% List<Drug> drugList = (List<Drug>) session.getAttribute("drugs");
        out.print(drugList);%>
        <tr>
            <td></td>

        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
