package test.practice.android_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by parasmani.sharma on 13/10/2017.
 */

public class ResponseDataPerson implements Parcelable{

    String PersonName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PersonName);
        dest.writeString(Address);
    }

    protected ResponseDataPerson(Parcel in) {
        PersonName = in.readString();
        Address = in.readString();
    }

    public static final Creator<ResponseDataPerson> CREATOR = new Creator<ResponseDataPerson>() {
        @Override
        public ResponseDataPerson createFromParcel(Parcel in) {
            return new ResponseDataPerson(in);
        }

        @Override
        public ResponseDataPerson[] newArray(int size) {
            return new ResponseDataPerson[size];
        }
    };

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    String Address;



}
