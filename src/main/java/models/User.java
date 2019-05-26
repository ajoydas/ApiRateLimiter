package models;

import utils.Logger;

import java.util.HashMap;

public class User {
    private String userName;
    private HashMap<String, Long> limits;
    private HashMap<String, Long> calls;

    public User(String userName) {
        this.userName = userName;
        limits = new HashMap<String, Long>();
        calls = new HashMap<String, Long>();
    }

    public Long getApiLimit(String apiName){
        return this.limits.get(apiName);
    }

    public void setApiLimit(String apiName, Long limit){
        this.limits.put(apiName, limit);
        this.calls.put(apiName, (long) 0);
    }

    public Long getApiCalled(String apiName){
        return this.calls.get(apiName);
    }

    public void setApiCalled(String apiName, Long call){
        this.calls.put(apiName, call);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", limits=" + limits +
                ", calls=" + calls +
                '}';
    }
}
