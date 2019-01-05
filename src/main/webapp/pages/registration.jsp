<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header-welcom.jspf" %>

        <div class="container mt-55">
            <div class="container-md">
                <div class="row">
                    <div class="col-md-12"><h1 class="h-home">Регистрация</h1></div>
                </div>
                <div class="row">
                    <form>
                        <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="exampleInputFirstName" placeholder="First name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="exampleInputLastName" placeholder="Last name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="exampleInputFatherName" placeholder="Father name">
                                </div>
                                <div class="form-group">
                                    <input type="date" class="form-control" id="exampleInputDate" placeholder="Birthday">
                                </div>
                        </div>
                        <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="exampleInputPhone" placeholder="Phone">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password again">
                                </div>

                        </div>
                        <div class="col-md-12 text-center">
                            <button type="submit" class="btn btn-success">Зарегистрироваться</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

<%@include file="includes/footer.jspf" %>
