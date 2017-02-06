package mportal.action;

import mportal.util.Global_Keys;

/**
 * Created by gtc-user34 on 12/7/2016.
 */
public class LogOutAction extends GlobalAction {

    public LogOutAction() throws Exception {

    }

    @Override
    public String execute(){
        mapSession.remove(Global_Keys.LOGIN);
        return SUCCESS;
    }
}
