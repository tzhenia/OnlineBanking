<jsp:include page="includes/header.jsp" ></jsp:include>

        <div class="container mt-55">
            <div class="row">
                <div class="col-md-12"><h1 class="h-home">Настройки счета</h1></div>
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
                        <div class="col-sm-6 text-center">
                            <h3 class="h-home">0000 0000 0000 0000</h3>
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="name" placeholder="Имя счета">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="limit" placeholder="Желаемый кредитный лимит">
                                </div>
                                <button type="submit" class="btn btn-success">Сохранить</button>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <h3 class="h-home">Важная информация</h3>
                            <p class="text-info-white">
                                После изменения кредитного лимита, Вашу заявка должна дождаться одобрения.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<jsp:include page="includes/footer.jsp" />