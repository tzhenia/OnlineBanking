<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jspf" %>

        <div class="container mt-55">
            <div class="row">
                <div class="col-md-12"><h1 class="h-home">Мои счета</h1></div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-12">
                            <div class="row bg-white-div mt-15 block-all-cards">
                                <div class="col-md-12">
                                    <a class="btn btn-success" href="transactions.jsp">Перевод на карту</a>
                                </div>
                                <div class="col-md-12 mt-10">
                                    <a href="#">0000 0000 0000 0000</a>
                                </div>
                                <div class="col-md-12 mt-10">
                                    <a href="#">0000 0000 0000 0000</a>
                                </div>
                                <div class="col-md-12 mt-10">
                                    <a href="#">0000 0000 0000 0000</a>
                                </div>
                                <div class="col-md-12 mt-15">
                                    <input class="btn btn-warning" type="submit" value="Добавить счет">
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-12">
                            <div class="row bg-white-div mt-15 block-credit-info">
                                <div class="col-md-12"><h4>Кредитний лимит:</h4></div>
                                <div class="col-md-12">0 <small>USD</small></div>

                                <div class="col-md-12"><h4>Насчитано</h4></div>
                                <div class="col-md-12">0 <small>USD</small></div>

                                <div class="col-md-12"><h4>Кредитная ставка</h4></div>
                                <div class="col-md-12">11 <small>%</small></div>

                                <div class="col-md-12 mt-15">
                                    <a class="btn btn-warning" href="cards-edit.jsp">Изменить</a>
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-sm-6 cards-balance">
                                12 345,94 <small>USD</small>
                            </div>
                            <div class="col-sm-6 cards-info">
                                Универсальна карта <br>
                                0000 0000 0000 0000 <small>(12/2022)</small>
                            </div>
                        </div>
                    </div>

                    <div class="row bg-white-div">

                        <div class="col-sm-12"><h3 class="h3-xs">10 последних транзакций</h3></div>

                        <div class="col-sm-12 transaction-history">
                            <div class="row">
                                <div class="col-sm-9 transaction-history-name"><span class="transaction-history-date">11.11.2011 <small>13:59</small></span> 0000 0000 0000 0000 - Имя Фамилия</div>
                                <div class="col-sm-3 transaction-history-money money-minus">-22231,93 <small>USD</small></div>
                            </div>
                        </div>

                        <div class="col-sm-12 transaction-history">
                            <div class="row">
                                <div class="col-sm-9 transaction-history-name"><span class="transaction-history-date">11.11.2011 <small>13:59</small></span> 0000 0000 0000 0000 - Имя Фамилия</div>
                                <div class="col-sm-3 transaction-history-money money-plus">+22231,93 <small>USD</small></div>
                            </div>
                        </div>

                        <div class="col-sm-12 transaction-history">
                            <div class="row">
                                <div class="col-sm-9 transaction-history-name"><span class="transaction-history-date">11.11.2011 <small>13:59</small></span> 0000 0000 0000 0000 - Имя Фамилия</div>
                                <div class="col-sm-3 transaction-history-money money-plus">+22231,93 <small>USD</small></div>
                            </div>
                        </div>

                        <div class="col-sm-12 transaction-history">
                            <div class="row">
                                <div class="col-sm-9 transaction-history-name"><span class="transaction-history-date">11.11.2011 <small>13:59</small></span> 0000 0000 0000 0000 - Имя Фамилия</div>
                                <div class="col-sm-3 transaction-history-money money-minus">-22231,93 <small>USD</small></div>
                            </div>
                        </div>

                        <div class="col-sm-12 transaction-history">
                            <div class="row">
                                <div class="col-sm-9 transaction-history-name"><span class="transaction-history-date">11.11.2011 <small>13:59</small></span> 0000 0000 0000 0000 - Имя Фамилия</div>
                                <div class="col-sm-3 transaction-history-money money-minus">-22231,93 <small>USD</small></div>
                            </div>
                        </div>

                        <div class="col-sm-12 transaction-history">
                            <div class="row">
                                <div class="col-sm-9 transaction-history-name"><span class="transaction-history-date">11.11.2011 <small>13:59</small></span> 0000 0000 0000 0000 - Имя Фамилия</div>
                                <div class="col-sm-3 transaction-history-money money-plus">+22231,93 <small>USD</small></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<%@include file="includes/footer.jspf" %>