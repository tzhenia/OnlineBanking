<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="tzhenia.com">
    <link rel="icon" href="../img/favicon.ico">
    <title>Мои счета | Online Banking</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../css/media.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/pages/dashboard.jsp">online Banking</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Счета <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="active"><a href="/pages/cards.jsp">Мои счета</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/pages/invoice.jsp">Инвойсы</a></li>
                            </ul>
                        </li>

                        <li><a href="/pages/deposit.jsp">Депозит</a></li>
                        <li><a href="/pages/transactions.jsp">Транзакции</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Другое <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/pages/settings.jsp">Настройки</a></li>
                                <li><a href="/pages/opportunities.jsp">Возможности</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Администрирование</li>
                                <li><a href="/pages/manage.jsp">Банкир</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/pages/settings.jsp" class="hidden-xs hidden-sm">ID: 11</a></li>
                        <li><a href="tel:+1234567890">+1234567890</a></li>
                        <li><a href="#"><img src="/img/flags/eng.png" class="language-icon"> English</a></li>
                        <!--<li class="active"><a href="#"><img src="img/flags/ru.png" class="language-icon"> Русский</a></li>-->
                        <li><a href="/pages/index.jsp">Выход</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>