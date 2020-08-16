package cn.gsxt.domain;

import java.util.List;

public class VoResult {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VoResult{" +
                "userList=" + userList +
                '}';
    }
}
