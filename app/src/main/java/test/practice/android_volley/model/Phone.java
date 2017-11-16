package test.practice.android_volley.model;

import java.io.Serializable;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class Phone implements Serializable{

    private String home;

    public String getHome() { return this.home; }

    public void setHome(String home) { this.home = home; }

    private String mobile;

    public String getMobile() { return this.mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

}
