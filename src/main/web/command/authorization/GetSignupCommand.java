package main.web.command.authorization;

import main.web.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetSignupCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(Util.isAlreadyLoggedIn(request.getSession())) {
//            Util.redirectTo(request, response, PagesPaths.HOME_PATH);
//            return REDIRECTED;
//        }

       // return SIGNUP_VIEW;

        return null;
    }
}