package by.epam.lapenok.model.validator;

public class UserValidator {
    private static final String SURNAME_REGEX = "^[а-яА-Яa-zA-Z]+$";
    private static final String LOGIN_REGEX = "^[a-zA-Z\\d]{8,20}$";
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$";

    public static boolean isUserSurnameValid(String name) {
        return name.matches(SURNAME_REGEX);
    }

    public static boolean isUserLoginValid(String login) {
        return login.matches(LOGIN_REGEX);
    }

    public static boolean isUserPasswordValid(String password) {
        return password.matches(PASSWORD_REGEX);
    }

}
