package main.web.servelet;

import main.persistence.entity.User;
import main.service.ServiceFactory;
import main.service.UserService;
import main.web.servelet.ServeletHelper.Method;
import main.web.command.ICommand;
import main.web.util.enums.PagesPaths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    private ServeletHelper controllerHelper;

    @Override
    public void init() throws ServletException {
        super.init();
        controllerHelper = ServeletHelper.Singleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response, Method.GET);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response, Method.POST);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response, Method method) throws ServletException, IOException {
        ICommand command = controllerHelper.getCommand(getPath(request), method);

        String path = command.execute(request, response);
        if (!path.equals(ICommand.REDIRECTED)) {
            request.getRequestDispatcher(path).forward(request, response);
        }
    }

    private String getPath(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return uri.replaceAll(PagesPaths.SITE_PREFIX.value, "");
    }
}