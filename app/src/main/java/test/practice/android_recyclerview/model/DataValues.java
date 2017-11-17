package test.practice.android_recyclerview.model;

import java.io.Serializable;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class DataValues implements Serializable {


    public DataValues(String name, String email)
    {
        this.name  = name;
        this.email = email;
    }


    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

}
