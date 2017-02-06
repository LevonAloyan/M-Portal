package mportal.action;

import mportal.dao.impl.RequestDaoImpl;
import mportal.domain.Request;
import mportal.util.Global_Keys;

/**
 * Created by RuBen on 08.12.2016.
 */
public class RequestAction  extends GlobalAction {
    private int senderId;
    private int acceptrID;
    private Request request;
    private RequestDaoImpl requestDao;

    public RequestAction() throws Exception {
        requestDao = new RequestDaoImpl();
        request = new Request();
    }

    @Override
    public String execute() throws Exception {
        senderId = (Integer) mapSession.get(Global_Keys.LOGIN);
        request.setAccepted(1);
        request.setAcceptrID(acceptrID);
        request.setSenderID(senderId);
        requestDao.create(request);
        return SUCCESS;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getAcceptrID() {
        return acceptrID;
    }

    public void setAcceptrID(int acceptrID) {
        this.acceptrID = acceptrID;
    }
}
