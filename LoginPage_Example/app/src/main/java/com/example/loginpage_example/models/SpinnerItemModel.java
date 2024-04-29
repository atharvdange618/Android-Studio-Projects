package com.example.loginpage_example.models;

public class SpinnerItemModel {
    private String tvCountryName;
    private int ivCountryIcon;

    public SpinnerItemModel(String tvCountryName, int ivCountryIcon) {
        this.tvCountryName = tvCountryName;
        this.ivCountryIcon = ivCountryIcon;
    }

    public String getTvCountry() {
        return tvCountryName;
    }

    public void setTvCountry(String tvCountry) {
        this.tvCountryName = tvCountry;
    }

    public int getIvCountryIcon() {
        return ivCountryIcon;
    }

    public void setIvCountryIcon(int ivCountryIcon) {
        this.ivCountryIcon = ivCountryIcon;
    }
}
