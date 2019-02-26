package com.moss.algorithm.naver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class TimeTest {

    @Test
    public void test() {
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(1988, 5, 7, 23, 0), ZoneId.of("Asia/Seoul"));
        System.out.println(time);
        System.out.println(time.toLocalDateTime());
        
        ZonedDateTime time2 = time.plusHours(1);
        System.out.println(time2);
        
        
        
        
        
    }
    
    @Test
    public void parseDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX");
        Date result = DatatypeConverter.parseDateTime("1900-01-25T00:00:00.000+09:00").getTime();
        String input2= format.format(result); // 1900-01-24 23:27:52.000+08:27
        //String input2 = "1900-01-24 23:27:52.000+08:27";
        Date result2 =  DatatypeConverter.parseDateTime(input2).getTime();
        //Date result2 = format.parse(input2); 
        System.out.println(format.format(result2));
    }
    
    @Test
    public void parseISO8601() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("1900-01-25T00:00:00.000+09:00");
        System.out.println(zonedDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("1900-01-25T00:00:00.000+09:00");
        System.out.println(offsetDateTime);
    }
}
