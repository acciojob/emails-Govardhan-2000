package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Mail {
    private Date date;
    private String senderId;
    private String message;

    public Mail(Date date, String senderId, String message) {
        this.date = date;
        this.senderId = senderId;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }
}

public class Gmail extends Email {

    private int inboxCapacity;
    private List<Mail> inbox;
    private List<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        if (inbox.size() >= inboxCapacity) {
            moveOldestMailToTrash();
        }
        inbox.add(new Mail(date, sender, message));
    }

    private void moveOldestMailToTrash() {
        if (!inbox.isEmpty()) {
            Mail oldestMail = inbox.remove(0);
            trash.add(oldestMail);
        }
    }

    public void deleteMail(String message) {
        Mail mailToDelete = null;
        for (Mail mail : inbox) {
            if (mail.getMessage().equals(message)) {
                mailToDelete = mail;
                break;
            }
        }
        if (mailToDelete != null) {
            inbox.remove(mailToDelete);
            trash.add(mailToDelete);
        }
    }

    public String findLatestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        Mail latestMail = inbox.get(inbox.size() - 1);
        return latestMail.getMessage();
    }

    public String findOldestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        Mail oldestMail = inbox.get(0);
        return oldestMail.getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end) {
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize() {
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }
}



