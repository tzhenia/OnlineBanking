package main.web.command.authorization;

import main.web.command.ICommand;
import main.web.util.Util;
import main.web.util.enums.Attributes;
import main.web.util.enums.PagesPaths;
import main.web.util.enums.Views;
import main.persistence.entity.User;
import main.service.ServiceFactory;
import main.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostSignupCommand implements ICommand {
    private final static String EMAIL_PARAM = "email";
    private final static String PASSWORD_PARAM = "password";
    private final static String FIRST_NAME_PARAM = "firstname";
    private final static String LAST_NAME_PARAM = "lastname";
    private final static String FATHER_NAME_PARAM = "fathername";
    private final static String PHONE_PARAM = "phone";

    private final UserService userService = ServiceFactory.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        if(Util.isAlreadyLoggedIn(request.getSession())) {
//            Util.redirectTo(request, response, PagesPaths.HOME_PATH);
//            return REDIRECTED;
//        }

 //       User userDto = getDataFromRequest(request);
 //       System.out.println(userDto.toString());

//        if(errors.isEmpty()) {
//            User createdUser = userService.createUser(userDto);
//            Account userAccount = createNewAccount(createdUser);
//            addUserToSession(request.getSession(), createdUser);
//            Util.redirectTo(request, response, PagesPaths.HOME_PATH);
//
//            return REDIRECTED;
//        }

 //       addInvalidDataToRequest(request, userDto);

        return Views.SIGNUP_VIEW.value;
    }

    private User getDataFromRequest(HttpServletRequest request) {
        return User.newBuilder()
                .setEmail(request.getParameter(EMAIL_PARAM))
                //.setPhone(request.getParameter(PHONE_PARAM))
                .setPassword(request.getParameter(PASSWORD_PARAM))
                .setFirstName(request.getParameter(FIRST_NAME_PARAM))
                .setLastName(request.getParameter(LAST_NAME_PARAM))
                .setFatherName(request.getParameter(FATHER_NAME_PARAM))
                //.setBirthday(request.getParameter(FATHER_NAME_PARAM))
                .build();
    }

//    private Account createNewAccount(User user) {
//        Account tempAccount = new Account(Account.DEFAULT_NUMBER, user, new BigDecimal(Account.DEFAULT_BALANCE), Account.Status.PENDING);
//        Account userAccount = accountService.createAccount(tempAccount);
//        return userAccount;
//    }

    private void addInvalidDataToRequest(HttpServletRequest request, User user) {
        request.setAttribute(Attributes.USER.value, user);
    }

    private void addUserToSession(HttpSession session, User user) throws IOException {
        session.setAttribute(Attributes.USER.value, user);
    }
}
