package codility.interview.db;

/**
 * Represents a log entry for a user viewing a page.
 * 
 * Contains the user's name, the date and time of the view, and the page viewed.
 */
public class LogEntry {

    private String name;
    private java.time.LocalDateTime dateTime;
    private String pageViewed;

    /**
     * Constructs a LogEntry with the specified name, date and time, and page viewed.
     * 
     * @param name The name of the user.
     * @param dateTime The date and time when the page was viewed.
     * @param pageViewed The page that was viewed by the user.
     */
    public LogEntry(String name, java.time.LocalDateTime dateTime, String pageViewed) {
        this.name = name;
        this.dateTime = dateTime;
        this.pageViewed = pageViewed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.time.LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(java.time.LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getPageViewed() {
        return pageViewed;
    }

    public void setPageViewed(String pageViewed) {
        this.pageViewed = pageViewed;
    }

    /**
     * Returns a string representation of the log entry.
     * 
     * @return A string containing the name, date and time, and page viewed.
     */
    @Override
    public String toString() {
        return "User: " + getName() + ", Date: " + getDateTime() + ", Page: " + getPageViewed();
    }
}
