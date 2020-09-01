<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jspf" %>

        <div class="container mt-55">
            <div class="row">
                <div class="col-md-12"><h1 class="h-home">Инвойсы</h1></div>
            </div>
            <div class="row">
                <form>
                    <div class="col-sm-2">
                        <div class="form-group">
                            <input type="text" class="form-control" id="idUser" placeholder="ID получателя">
                        </div>
                    </div>

                    <div class="col-sm-4">
                        <div class="form-group">
                            <select class="form-control">
                                <option selected>0000 0000 0000 0000 - Name card - 1233,73 USD</option>
                                <option>0000 0000 0000 0001 - Name card - 1233,73 USD</option>
                                <option>0000 0000 0000 0002 - Name card - 1233,73 USD</option>
                                <option>0000 0000 0000 0003 - Name card - 1233,73 USD</option>
                                <option>0000 0000 0000 0004 - Name card - 1233,73 USD</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <input type="text" class="form-control" id="text" placeholder="Сообщение получателю">
                        </div>
                    </div>

                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-success btn-md btn-block">Отправить</button>
                    </div>
                </form>
            </div>

            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12 mt-15">
                    <div class="row bg-white-div">
                        <div class="col-xs-12 cards-balance-on-white-bg ">123 USD</div>
                        <div class="col-xs-12 invoice-date">11.11.2011 <small>13:59</small></div>
                        <div class="col-xs-12 cards-number-on-white-bg mt-10">0000 0000 0000 0000</div>
                        <div class="col-xs-12 cards-name-on-white-bg">Имя получателя</div>
                        <div class="col-xs-12 cards-name-on-white-bg mt-15">Сообщение</div>
                        <div class="col-xs-12"><hr></div>
                        <div class="col-xs-12 bg-success text-center"><h5>Оплачен</h5></div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-6 col-xs-12 mt-15">
                    <div class="row bg-white-div">
                        <div class="col-xs-12 cards-balance-on-white-bg ">123 USD</div>
                        <div class="col-xs-12 invoice-date">11.11.2011 <small>13:59</small></div>
                        <div class="col-xs-12 cards-number-on-white-bg mt-10">0000 0000 0000 0000</div>
                        <div class="col-xs-12 cards-name-on-white-bg">Имя получателя</div>
                        <div class="col-xs-12 cards-name-on-white-bg mt-15">Сообщение</div>
                        <div class="col-xs-12"><hr></div>
                            <form>
                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <select class="form-control">
                                            <option selected="">0000 0000 0000 0000 - Name card - 1233,73 USD</option>
                                            <option>0000 0000 0000 0001 - Name card - 1233,73 USD</option>
                                            <option>0000 0000 0000 0002 - Name card - 1233,73 USD</option>
                                            <option>0000 0000 0000 0003 - Name card - 1233,73 USD</option>
                                            <option>0000 0000 0000 0004 - Name card - 1233,73 USD</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xs-12 text-right">
                                    <button type="submit" class="btn btn-success btn-md btn-block">Оплатить</button>
                                </div>

                                <div class="col-xs-12 text-right">
                                    <button type="submit" class="btn btn-danger btn-md btn-block mt-7">В архив</button>
                                </div>
                            </form>
                    </div>
                </div>

                <div class="col-md-4 col-sm-6 col-xs-12 mt-15">
                    <div class="row bg-white-div">
                        <div class="col-xs-12 cards-balance-on-white-bg ">123 USD</div>
                        <div class="col-xs-12 invoice-date">11.11.2011 <small>13:59</small></div>
                        <div class="col-xs-12 cards-number-on-white-bg mt-10">0000 0000 0000 0000</div>
                        <div class="col-xs-12 cards-name-on-white-bg">Имя получателя</div>
                        <div class="col-xs-12 cards-name-on-white-bg mt-15">Сообщение</div>
                        <div class="col-xs-12"><hr></div>
                        <div class="col-xs-12 bg-danger text-center"><h5>Архив</h5></div>
                    </div>
                </div>
            </div>
        </div>

<%@include file="includes/footer.jspf" %>
