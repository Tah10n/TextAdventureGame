<%@ page import="org.example.TextAdventureGame" %>
<%@ page import="org.example.Location" %>
<%@ page import="org.example.Scene" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Adventure Game</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
    <%
    if(request.getAttribute("location") == "Хоббитон") {
    out.print("body {background-image: url(\"/resources/Hobbiton.jpg\"); background-size: cover; background-repeat: no-repeat;}");
    }
    if(request.getAttribute("location") == "Таверна") {
    out.print("body {background-image: url(\"/resources/Tavern.jpg\"); background-size: cover; background-repeat: no-repeat;}");
    }
    if(request.getAttribute("location") == "Одинокая гора") {
    out.print("body {background-image: url(\"/resources/Mountain.jpg\"); background-size: cover; background-repeat: no-repeat;}");
    }
%>
</style>
<body>
<div class="container">


    <p><%= request.getAttribute("description") %>
    </p>

    <%
        TextAdventureGame game = (TextAdventureGame) request.getAttribute("game");

        Scene curScene = game.getCurrentScene();
        List<String> actions = curScene.getActions();
        for (String action : actions) {

            out.println("<a href = \"/game?input=" + action + "\">" + action + "</a ><br><br>");

        }

        if (game.isGameEnded()) {

    %>
    <a href="/index.jsp">Начать заново</a>
    <br>
    <%
        }
    %>
</div>


<br>
<p>Статистика:</p>
<p><%= request.getSession().getId() %>
</p>

<p>Имя игрока: <%= request.getSession().getAttribute("playerName") %>
</p>
<p>гномы встречены:<%= game.isDwarfsMet()%>
</p>
<p>игра закончена:<%= game.isGameEnded()%>
</p>

</body>
</html>
