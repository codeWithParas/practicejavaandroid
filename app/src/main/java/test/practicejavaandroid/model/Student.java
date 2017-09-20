package test.practicejavaandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by parasmani.sharma on 20/09/2017.
 */

public class Student implements Parcelable {

    public Student(String name, int roll)
    {
        this.name = name;
        this.rollnumber = roll;
    }

    public Student(Parcel in) {
        name = in.readString();
        rollnumber = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(int rollnumber) {
        this.rollnumber = rollnumber;
    }

    String name;
    int rollnumber;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(rollnumber);
    }
}
