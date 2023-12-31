package com.driver;

import java.util.ArrayList;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        // Add the meeting to the calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // Find the maximum number of meetings you can attend:
        // 1. At a particular time, you can be present in at most one meeting.
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am.

        int maxMeetings = 0;
        for (Meeting meeting : calendar) {
            int currentMeetings = 1;
            for (Meeting otherMeeting : calendar) {
                if (meeting != otherMeeting) {
                    if (meeting.getStartTime().isBefore(otherMeeting.getEndTime()) &&
                            meeting.getEndTime().isAfter(otherMeeting.getStartTime())) {
                        currentMeetings = 0; // Overlapping meetings, can't attend this meeting
                        break;
                    }
                }
            }
            maxMeetings = Math.max(maxMeetings, currentMeetings);
        }
        return maxMeetings;
    }
}
