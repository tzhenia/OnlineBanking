package main.web.servelet;

import main.web.command.DefaultCommand;
import main.web.command.HomeCommand;
import main.web.command.ICommand;
import main.web.command.authorization.*;
import main.web.util.enums.PagesPaths;
import java.util.HashMap;
import java.util.Map;

public class ServeletHelper {
    private final static String DELIMITER = ":";
    private final DefaultCommand DEFAULT_COMMAND = new DefaultCommand();
    private Map<String, ICommand> commands = new HashMap<>();

    private ServeletHelper() {
        init();
    }

    private void init() {
        commands.put(buildKey(PagesPaths.HOME_PATH.value, Method.GET), new HomeCommand());
        commands.put(buildKey(PagesPaths.LOGOUT_PATH.value, Method.GET), new LogoutCommand());

        commands.put(buildKey(PagesPaths.LOGIN_PATH.value, Method.GET), new GetLoginCommand());
        commands.put(buildKey(PagesPaths.LOGIN_PATH.value, Method.POST), new PostLoginCommand());

        commands.put(buildKey(PagesPaths.SIGNUP_PATH.value, Method.GET), new GetSignupCommand());
        commands.put(buildKey(PagesPaths.SIGNUP_PATH.value, Method.POST), new PostSignupCommand());
    }

    public ICommand getCommand(String path, Method method) {
        return commands.getOrDefault(buildKey(path, method), DEFAULT_COMMAND);
    }

    private String buildKey(String path, Method method) {
        return method.name() + DELIMITER + path;
    }

    public enum Method {
        GET, POST
    }

    public static class Singleton {
        private final static ServeletHelper INSTANCE = new ServeletHelper();

        public static ServeletHelper getInstance() {
            return INSTANCE;
        }
    }
}
