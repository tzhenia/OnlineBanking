package main.web.command;

import main.web.util.Util;
import main.web.util.enums.PagesPaths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Util.redirectTo(request, response, PagesPaths.HOME_PATH.value);
        return REDIRECTED;
    }
}