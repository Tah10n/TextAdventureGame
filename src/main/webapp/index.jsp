<%@ page import="org.example.TextAdventureGame" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Text Adventure Game</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Добро пожаловать в путешествие по Средиземью!</h1>
    <p> Готов ли ты отправиться в удивительное приключение?</p>
    <p> Тебя ждут опасные враги, таинственные существа и невероятные открытия!</p>
    <p> Великое приключение начинается прямо сейчас!</p>
    <br>
    <p> Введи свое имя:</p>
    <input type="text" id="name" name="name" required minlength="3" maxlength="10" size="10" placeholder="Незнакомец"
           onchange='eventForm(this.value)'/><br><br>
    <br>
    <a href="/game">Начать путешествие</a>
</div>

<script>
    var name = "Незнакомец"

    function eventForm(value) {
        name = value;
    }

</script>
<%
    session = request.getSession();
    String name = "<script>document.writeln(name)</script>";
    session.setAttribute("playerName", name);

%>
</body>
</html>
