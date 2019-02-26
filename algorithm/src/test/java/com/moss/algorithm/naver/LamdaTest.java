package com.moss.algorithm.naver;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaTest {
    
    private ReportRepository repository;
    
    public static class Guest {
        private int grade;
        private String name;
        private String company;
        public int getGrade() {
            return grade;
        }
        public String getName() {
            return name;
        }
        public String getCompany() {
            return company;
        }
        
        
    }
    

    public List<String> findGuestNamesByCompany(String company) {
        List<Guest> guests = repository.findAll();
        return guests.stream()
                .filter(g -> company.equals(g.getCompany()))
                .sorted(Comparator.comparing(g -> g.getGrade()))
                .map(g -> g.getName())
                .collect(Collectors.toList());
    }
    
    public List<String> findGuestNamesByCompany2(String company) {
        List<Guest> guests = repository.findAll();
        return guests.stream()
                .filter(g -> company.equals(g.getCompany()))
                .sorted(Comparator.comparing(Guest::getGrade))
                .map(Guest::getName)
                .collect(Collectors.toList());
    }
    
    public List<String> findGuestNamesByCompany3(String company) {
        List<Guest> guests = repository.findAll();
        Stream<Guest> stream = guests.stream();
        
        // filtering
        Predicate<Guest> filterFunc = g -> company.equals(g.getCompany());
        Stream<Guest> filtered = stream.filter(filterFunc);
        
        // sorting
        Comparator<Guest> sortFunc = Comparator.comparing(Guest::getGrade);
        Stream<Guest> sorted = filtered.sorted(sortFunc);
        
        // mapping
        Function<Guest, String> mapFunc = Guest::getName;
        Stream<String> mapped = sorted.map(mapFunc);
        Collector<String, ?, List<String>> collector = Collectors.toList();
        return mapped.collect(collector);
    }
    
    
}
