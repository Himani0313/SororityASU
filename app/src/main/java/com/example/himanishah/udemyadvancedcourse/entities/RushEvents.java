package com.example.himanishah.udemyadvancedcourse.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by himanishah on 8/28/17.
 */

public class RushEvents implements Parcelable{

    private  int eventId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private double eventLatitude;
    private double eventsLongitude;
    private boolean isOnCampus;
    private String eventDiscription;

    public RushEvents(int eventId, String eventName, String eventDate,String eventTime, String eventLocation, double eventLatitude, double eventsLongitude, boolean isOnCampus, String eventDiscription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventLatitude = eventLatitude;
        this.eventsLongitude = eventsLongitude;
        this.isOnCampus = isOnCampus;
        this.eventDiscription = eventDiscription;
    }

    protected RushEvents(Parcel in) {
        eventId = in.readInt();
        eventName = in.readString();
        eventDate = in.readString();
        eventTime = in.readString();
        eventLocation = in.readString();
        eventLatitude = in.readDouble();
        eventsLongitude = in.readDouble();
        isOnCampus = in.readByte() !=0;
        eventDiscription = in.readString();

    }

    public static final Creator<RushEvents> CREATOR = new Creator<RushEvents>() {
        @Override
        public RushEvents createFromParcel(Parcel in) {
            return new RushEvents(in);
        }

        @Override
        public RushEvents[] newArray(int size) {
            return new RushEvents[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventId);
        dest.writeString(eventName);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(eventLocation);
        dest.writeDouble(eventLatitude);
        dest.writeDouble(eventsLongitude);
        dest.writeByte((byte) (isOnCampus ?1:0));
        dest.writeString(eventDiscription);
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public double getEventLatitude() {
        return eventLatitude;
    }

    public double getEventsLongitude() {
        return eventsLongitude;
    }

    public boolean isOnCampus() {
        return isOnCampus;
    }

    public String getEventDiscription() {
        return eventDiscription;
    }
}
