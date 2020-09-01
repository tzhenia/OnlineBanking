<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header-welcom.jspf" %>

        <div class="container mt-55">
            <div class="container-md">
                <div class="row">
                    <div class="col-md-12"><h1 class="h-home">Регистрация</h1></div>
                </div>
                <div class="row">
                    <form method="post">
                        <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="inp1" placeholder="First name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="inp2" placeholder="Last name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="inp3" placeholder="Father name">
                                </div>
                                <div class="form-group">
                                    <input type="date" class="form-control" id="inp4" placeholder="Birthday">
                                </div>
                        </div>

                        <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="inp5" placeholder="Phone">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" id="inp6" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" id="inp7" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" id="inp8" placeholder="Password again">
                                </div>
                        </div>
                        <div class="col-md-12 text-center">
                            <input type="submit" value="Зарегистрироваться" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>

<%@include file="includes/footer.jspf" %>
