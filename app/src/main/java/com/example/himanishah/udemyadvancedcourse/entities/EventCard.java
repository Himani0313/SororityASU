package com.example.himanishah.udemyadvancedcourse.entities;

/**
 * Created by himanishah on 8/25/17.
 */

public class EventCard {
    private int eventId;
    private String eventName;
    private String eventDesc;
    private String eventImage;
    private boolean isVideo;
    private String youtubeEnding;

    public EventCard(int eventId, String eventName, String eventDesc, String eventImage, boolean isVideo, String youtubeEnding) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventImage = eventImage;
        this.isVideo = isVideo;
        this.youtubeEnding = youtubeEnding;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public String getEventImage() {
        return eventImage;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public String getYoutubeEnding() {
        return youtubeEnding;
    }
}
