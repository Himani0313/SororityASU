package com.example.himanishah.udemyadvancedcourse.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by himanishah on 8/19/17.
 */

public class Sister implements Parcelable {
    private int sisterId;
    private String sisterName;
    private String sisterWhyJoin;
    private String sisterPic;
    private String sisterMajor;
    private String sisterSemester;
    private String sisterFunFact;

    public Sister(int sisterId, String sisterName, String sisterWhyJoin, String sisterPic, String sisterMajor, String sisterSemester, String sisterFunFact) {
        this.sisterId = sisterId;
        this.sisterName = sisterName;
        this.sisterWhyJoin = sisterWhyJoin;
        this.sisterPic = sisterPic;
        this.sisterMajor = sisterMajor;
        this.sisterSemester = sisterSemester;
        this.sisterFunFact = sisterFunFact;
    }

    protected Sister(Parcel in) {
        sisterId = in.readInt();
        sisterName = in.readString();
        sisterWhyJoin = in.readString();
        sisterPic = in.readString();
        sisterMajor = in.readString();
        sisterSemester = in.readString();
        sisterFunFact = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sisterId);
        dest.writeString(sisterName);
        dest.writeString(sisterWhyJoin);
        dest.writeString(sisterPic);
        dest.writeString(sisterMajor);
        dest.writeString(sisterSemester);
        dest.writeString(sisterFunFact);

    }

    public int getSisterId() {
        return sisterId;
    }

    public String getSisterName() {
        return sisterName;
    }

    public String getSisterWhyJoin() {
        return sisterWhyJoin;
    }

    public String getSisterPic() {
        return sisterPic;
    }

    public String getSisterMajor() {
        return sisterMajor;
    }

    public String getSisterSemester() {
        return sisterSemester;
    }

    public String getSisterFunFact() {
        return sisterFunFact;
    }

    public static final Creator<Sister> CREATOR = new Creator<Sister>() {
        @Override
        public Sister createFromParcel(Parcel in) {
            return new Sister(in);
        }

        @Override
        public Sister[] newArray(int size) {
            return new Sister[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


}
