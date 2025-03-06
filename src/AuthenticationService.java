import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> authenticUsers;

    // TODO Now: Add a constructor to initialize the users list with the default user
    public AuthenticationService(ArrayList<User> users) {
        this.authenticUsers = users;
    }


    // TODO Now: Implement the signUp method to add a new user to the list if the username is not taken and return the user; returns null otherwise
    @Override
    public User signUp(String username, String password) {
        // Checks if username is already in the system
        for (User user : authenticUsers) {
            if(user.getUsername().equals(username)) {
                System.out.println("Username already taken. Please choose a different one.");
                return null;
            }
        }

        // If username is new and unique
        User newUser = new User(username, password);
        authenticUsers.add(newUser);
        System.out.println("Sign-up successful!");
        return newUser;
    }
    // TODO Now: Implement the logIn method to return the user if the username and password match, and null otherwise
    @Override
    public User logIn(String username, String password) {
        // Checks if username and password are entered are in the system
        for (User user : authenticUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        // If no match is found
        System.out.println("Invalid username or password.");
        return null;
    }

}
