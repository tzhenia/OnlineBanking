<jsp:include page="includes/header.jsp" ></jsp:include>

        <div class="container mt-55">

            <div class="container-md">
                <div class="row">
                    <div class="col-md-12"><h1 class="h-home">Настройки</h1></div>
                </div>
                <div class="row">
                    <div class="col-xs-12"><h4 class="h-home h3-xs">ID: 11, Фамилия Имя Отчество, 31.03.1993</h4></div>
                </div>


                <div class="row">
                    <div class="col-xs-12 col-sm-6 mt-25">
                        <h4 class="h-home h3-xs">Изменить контакты</h4>
                        <form>

                            <div class="form-group">
                                <input type="text" class="form-control" id="exampleInputPhone" placeholder="Phone">
                            </div>

                            <div class="form-group">
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn-block">Сохранить</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-xs-12 col-sm-6 mt-25">
                        <h4 class="h-home h3-xs">Изменить пароль</h4>
                        <form>
                            <div class="form-group">
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password again">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn-block">Сохранить</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

<jsp:include page="includes/footer.jsp" />