package codility.interview.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LoyaltyProgram {
    
    private HashMap<String, Set<String>> logOneUserPageMap = new HashMap<String, Set<String>>();
    private HashMap<String, Set<String>> logTwoUserPageMap = new HashMap<String, Set<String>>();
    private HashMap<String, Set<String>> loyalUsersPageMap = new HashMap<String, Set<String>>();

    /**
     * Constructor that takes two iterators of LogEntry objects.
     * It processes the log entries and populates the logOneUserPageMap map.
     *
     * @param iterator1 Iterator for the first day's log entries
     * @param iterator2 Iterator for the second day's log entries
     */
    public LoyaltyProgram(Iterator<LogEntry> iterator1, Iterator<LogEntry> iterator2) {
        
        while (iterator1.hasNext()){
            LogEntry entry = iterator1.next();
            System.out.println(entry);
            logOneUserPageMap.computeIfAbsent(entry.getName(), k -> new HashSet<String>()).add(entry.getPageViewed());
        }

        while (iterator2.hasNext()){
            LogEntry entry = iterator2.next();
            System.out.println(entry);
            logTwoUserPageMap.computeIfAbsent(entry.getName(), k -> new HashSet<String>()).add(entry.getPageViewed());
        }

        for (String key : logOneUserPageMap.keySet()) {
            if (logTwoUserPageMap.containsKey(key)) {
                Set<String> set1 = logOneUserPageMap.get(key);
                Set<String> set2 = logTwoUserPageMap.get(key);

                // Only merge if both sets are non-empty
                if (!set1.isEmpty() && !set2.isEmpty()) {
                    Set<String> combined = new HashSet<>();
                    combined.addAll(set1);
                    combined.addAll(set2);
                    loyalUsersPageMap.put(key, combined);
                }
            }
        }


    }

    /**
     * Returns a list of loyal users who have viewed at least two different pages.
     *
     * @return List of loyal users
     */
    public List<String> getLoyalUsers() {
        return loyalUsersPageMap.keySet().stream()
                .filter(user -> loyalUsersPageMap.get(user).size() >= 2)
                .collect(Collectors.toList());
    }

    /**
     * Parses a log file and returns a list of LogEntry objects.
     *
     * @param file The log file to parse
     * @return List of LogEntry objects
     * @throws Exception If an error occurs while reading the file
     */
    public static List<LogEntry> parseLogFile(File file) throws Exception {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<LogEntry> logEntries = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        bufferedReader.lines().forEach(line -> {
            String[] parts = line.split(",");
            LogEntry logEntry = new LogEntry(
                parts[0], 
                LocalDateTime.parse(parts[1], formatter),
                parts[2]);
            logEntries.add(logEntry);
        });

        bufferedReader.close();
        fileReader.close();

        return logEntries;
    }

    /**
     * Main method to run the Loyalty program.
     * It reads log files and processes them to find loyal users.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
    
        System.out.println(System.getProperty("user.dir"));
        File log_day1 = new File("src/codility/interview/db/log_day1.csv");
        File log_day2 = new File("src/codility/interview/db/log_day2.csv");
        List<LogEntry> logEntries1 = new ArrayList<>();
        List<LogEntry> logEntries2 = new ArrayList<>();

        try {
            logEntries1 = parseLogFile(log_day1);
            logEntries2 = parseLogFile(log_day2);
            LoyaltyProgram loyalityProgram = new LoyaltyProgram(logEntries1.iterator(), logEntries2.iterator());
            System.out.println(loyalityProgram.getLoyalUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
