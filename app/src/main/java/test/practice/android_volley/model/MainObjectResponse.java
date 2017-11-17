package test.practice.android_volley.model;

import java.io.Serializable;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class MainObjectResponse implements Serializable {

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private Phone phone;

    public Phone getPhone() { return this.phone; }

    public void setPhone(Phone phone) { this.phone = phone; }

}
