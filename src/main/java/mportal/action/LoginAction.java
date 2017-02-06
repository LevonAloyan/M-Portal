package mportal.action;

import mportal.action.utils.MD5;
import mportal.dao.impl.UserDaoImpl;
import mportal.domain.User;
import mportal.util.Global_Keys;

/**
 * Created by admin on 11/14/2016.
 */
public class LoginAction extends GlobalAction {

    private String email;
    private String password;
    private UserDaoImpl userDaoImpl;

    public LoginAction() throws Exception {
        userDaoImpl = new UserDaoImpl();

    }

    public String execute() throws Exception {
        User user = userDaoImpl.getUserByEmailPassword(email, MD5.encryptPassword(password));
        mapSession.put(Global_Keys.LOGIN, user.getId());
        return SUCCESS;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate() {
        try {

            User user = userDaoImpl.getUserByEmailPassword(email, MD5.encryptPassword(password));
            if (email.length() != 0 && password.length() != 0 && user == null) {
                addFieldError("email", "Your login or password is invalid");
            } else if (user != null && !user.isActive()) {
                addFieldError("email", "Please activate your profile ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
