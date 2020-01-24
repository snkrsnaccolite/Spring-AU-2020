import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Duration;
import java.util.TimeZone;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTime {
    public static Long findDOBDifference(String myDOB, String siblingDOB) throws ParseException {
        // My DOB - Europe/London
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        Date myDOBDate = formatter.parse(myDOB);

        ZonedDateTime myDOBDateTime = myDOBDate.toInstant().atZone(ZoneId.of("Europe/London"));

        // Sibling's DOB - Asia/India
        LocalDateTime siblingDOBDateTime = LocalDate.parse(siblingDOB).atStartOfDay();
        // Sibling's DOB - Europe/London
        ZonedDateTime zonedSiblingDOBDateTime = siblingDOBDateTime.atZone(ZoneId.of("Europe/London"));

        // Age difference
        Duration difference = Duration.between(zonedSiblingDOBDateTime, myDOBDateTime);

        return difference.toNanos();
    }

    public static void main(String[] args) throws ParseException {
        Long ageDifference = findDOBDifference("1996-02-29", "1990-01-01");

        System.out.println("Age difference in nanoseconds: " + ageDifference);
    }
}
