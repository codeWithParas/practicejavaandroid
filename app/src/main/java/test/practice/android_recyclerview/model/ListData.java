package test.practice.android_recyclerview.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

public class ListData implements Serializable {

    public ArrayList<DataValues> getList() {
        return list;
    }

    public void setList(ArrayList<DataValues> list) {
        this.list = list;
    }

    public ArrayList<DataValues> list = new ArrayList<>();

}
