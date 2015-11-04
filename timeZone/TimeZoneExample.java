package timeZone;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneExample {
    public static void main(String[] args) {
//        // Create a calendar object and set it time based on the local
//        // time zone
//        Calendar localTime = Calendar.getInstance();
////        localTime.set(Calendar.HOUR, 17);
////        localTime.set(Calendar.MINUTE, 15);
////        localTime.set(Calendar.SECOND, 20);
//        
//        int hour = localTime.get(Calendar.HOUR);
//        int minute = localTime.get(Calendar.MINUTE);
//        int second = localTime.get(Calendar.SECOND);
//
//        // Print the local time
//        System.out.printf("Local time  : %02d:%02d:%02d\n", hour, minute, second);
//        
//        
//        Calendar myBirthday = Calendar.getInstance();
//        myBirthday.setTimeZone(TimeZone.getTimeZone("China"));
//        myBirthday.set(1991, 7, 23, 16, 0, 0);
//        
//        Calendar usMyBirth = new GregorianCalendar();
//        usMyBirth.setTimeInMillis(myBirthday.getTimeInMillis());
////        int year = usMyBirth.get(Calendar.YEAR);
////        int month = usMyBirth.get(Calendar.MONTH);
////        int day = usMyBirth.get(Calendar.DAY_OF_MONTH);
//        hour = usMyBirth.get(Calendar.HOUR);
//        minute = usMyBirth.get(Calendar.MINUTE);
//        second = usMyBirth.get(Calendar.SECOND);
//        
//        System.out.println(hour + ":" + minute + ":" + second);
//
//        // Create a calendar object for representing a Germany time zone. Then we
//        // wet the time of the calendar with the value of the local time
//
//        Calendar germanyTime = new GregorianCalendar(TimeZone.getTimeZone("Europe/Berlin"));
//        germanyTime.setTimeInMillis(localTime.getTimeInMillis());
//        hour = germanyTime.get(Calendar.HOUR);
//        minute = germanyTime.get(Calendar.MINUTE);
//        second = germanyTime.get(Calendar.SECOND);
//
//
//        // Print the local time in Germany time zone
//        System.out.printf("Germany time: %02d:%02d:%02d\n", hour, minute, second);
    	
        Calendar calendar = Calendar.getInstance();
        TimeZone fromTimeZone = calendar.getTimeZone();
        TimeZone toTimeZone = TimeZone.getTimeZone("CST");
        //Date birthday = new Date(1991, 7, 23, 14, 0, 0);
        
        calendar.setTimeZone(fromTimeZone);
        //calendar.setTime(birthday);
        calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
        if (fromTimeZone.inDaylightTime(calendar.getTime())) {
            calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
        }

        calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
        if (toTimeZone.inDaylightTime(calendar.getTime())) {
            calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
        }
        
        calendar.setTimeZone(toTimeZone);

        System.out.println(calendar.getTime());
    }
}
