package main.web.util;

import main.web.util.enums.Attributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Util {
    /**
     * Add next page to redirect
     *
     * @param request
     * @param response
     * @param pageToRedirect
     * @throws IOException
     */
    public static void redirectTo(HttpServletRequest request, HttpServletResponse response, String pageToRedirect) throws IOException {
        response.sendRedirect(request.getServletPath() + pageToRedirect);
    }

    /**
     * Check if the user is logged in
     * @param session
     * @return {@code true} if logged in else {@code false}
     */
    public static boolean isAlreadyLoggedIn(HttpSession session) {
        return session.getAttribute(Attributes.USER.value) != null;
    }
}
