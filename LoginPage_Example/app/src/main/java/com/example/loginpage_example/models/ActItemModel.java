package com.example.loginpage_example.models;

public class ActItemModel {
    private String actStateName;

    public ActItemModel(String actStateName) {
        this.actStateName = actStateName;
    }

    public String getTvState() {
        return actStateName;
    }

    public void setTvState(String tvState) {
        this.actStateName = tvState;
    }

}
