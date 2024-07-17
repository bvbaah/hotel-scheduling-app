package edu.wgu.d387_sample_code.assessment;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimezoneConverter {

    public String getTimezones(){

        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUTC = ZoneId.of("UTC");

        LocalDateTime localDateTime = LocalDateTime.now();
        // Set time to 1:00 PM (abitrary)
        LocalDateTime localDateTimeEastern = LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime().withHour(13).withMinute(0));

        ZonedDateTime zonedDateTimeEastern = localDateTimeEastern.atZone(zEastern);
        ZonedDateTime zonedDateTimeMountain = zonedDateTimeEastern.withZoneSameInstant(zMountain);
        ZonedDateTime zonedDateTimeUTC = zonedDateTimeEastern.withZoneSameInstant(zUTC);

        //Format time in hours and minutes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String timeEastern = zonedDateTimeEastern.format(formatter);
        String timeMountain = zonedDateTimeMountain.format(formatter);
        String timeUTC = zonedDateTimeUTC.format(formatter);

        String message = "Please join us for a fantastic online, live presentation held at the Landon Hotel at " +
                "Eastern Time: " + timeEastern + ", " +
                "Mountain Time: " + timeMountain + ", " +
                "UTC Time: " + timeUTC + ".";

        return message;

    }
}
