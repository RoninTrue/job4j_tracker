package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                rsl = user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Users is not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || !(user.getUsername().length() >= 3)) {
            throw new UserInvalidException("user is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr", true)};
        try {
            User user = findUser(users, "Petr");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            System.out.println(uie.getMessage());
        } catch (UserNotFoundException nfe) {
            System.out.println(nfe.getMessage());
        }
    }
}
