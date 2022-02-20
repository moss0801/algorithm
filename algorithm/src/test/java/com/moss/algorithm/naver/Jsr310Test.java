package com.moss.algorithm.naver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Jsr310Test {

    @Test
    public void shouldGetAfterOneDay() {
        LocalDate theDay = IsoChronology.INSTANCE.date(1582, 10, 4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        Assertions.assertEquals(theDay.format(formatter), "1582.10.04");
        
        LocalDate nextDay = theDay.plusDays(1);
        Assertions.assertEquals(nextDay.format(formatter), "1582.10.05");
    }
    
    @Test
    public void shouldGetAfterOneMinute() {
        ZoneId seoul = ZoneId.of("Asia/Seoul");
        ZonedDateTime theTime = ZonedDateTime.of(1961, 8, 9, 23, 59, 59, 0, seoul);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        Assertions.assertEquals("1961.08.09 23:59", theTime.format(formatter));
        
        ZonedDateTime after1Minute = theTime.plusMinutes(1);
        Assertions.assertEquals("1961.08.10 00:30", after1Minute.format(formatter));
    }
    
    @Test
    public void shouldGetAfterTowSecond() {
        ZoneId utc = ZoneId.of("UTC");
        ZonedDateTime theTime = ZonedDateTime.of(2012,  6, 30, 23, 59, 59, 0, utc);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        Assertions.assertEquals("2012.06.30 23:59:59", theTime.format(formatter));
        
        ZonedDateTime after2Seconds = theTime.plusSeconds(2);
        Assertions.assertEquals("2012.07.01 00:00:01", after2Seconds.format(formatter));
    }
    
    @Test
    public void shouldGetDate() {
        LocalDate theDay = LocalDate.of(1999, 12, 31);
        
        Assertions.assertEquals(1999, theDay.getYear());
        Assertions.assertEquals(12, theDay.getMonthValue());
        Assertions.assertEquals(31, theDay.getDayOfMonth());
    }
    
    // 예제 1-9: 1999년 12월 31일을 지정하는 코드의 실수
    @Test
    public void shouldNotAcceptWrongDate() {
        assertThrows(DateTimeException.class, () -> {
            LocalDate.of(1999, 13, 31);
        });

    }
    
    // 예제 1-10: 요일 확인하기
    @Test
    public void shouldGetDayOfWeek() {
        LocalDate theDay = LocalDate.of(2014, 1, 1);
        
        DayOfWeek dayOfWeek = theDay.getDayOfWeek();
        Assertions.assertEquals(DayOfWeek.WEDNESDAY, dayOfWeek);
    }
    
    // 예제 1-11: 잘못 지정한 시간대 아이디
    @Test
    public void shouldThrowExceptionWhenWrongTimeZoneId() {
        assertThrows(ZoneRulesException.class, () -> {
            ZoneId.of("Seoul/Asia");
        });
    }
}
