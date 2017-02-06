package mportal.action;

import mportal.dao.impl.UserDaoImpl;
import mportal.domain.User;
import mportal.util.Global_Keys;

/**
 * Created by gtc-user34 on 12/7/2016.
 */
public class DeleteAcountAction extends GlobalAction {
    private UserDaoImpl userDao;

    public DeleteAcountAction() throws Exception {
        userDao= new UserDaoImpl();
    }

    @Override
    public String execute() throws Exception{
        Integer id= (Integer) mapSession.get(Global_Keys.LOGIN);
        User user=userDao.getById(id);
        userDao.delete(user);
        return SUCCESS;
    }
}
