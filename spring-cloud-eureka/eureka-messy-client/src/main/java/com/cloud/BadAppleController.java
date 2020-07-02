package com.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class BadAppleController {

    @RequestMapping("/ba/boxing")
    static public String boxing(){
        Integer size = 1000000;
        List<Double> randoms = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randoms.add(100*Math.random());
        }

        randoms.removeIf(d->(d < 50));

        return "50/50 ? "+ 100*randoms.size()/size;
    }


    static private List<String> rarelyValidList(){
        return Math.random() < 0.01 ? new ArrayList<String>():null;
    }


    @RequestMapping("/ba/falseSafety")
    static public String falseSafety(){
        List<String> tokens = rarelyValidList();
        StringBuilder sb = new StringBuilder();
        try {
            for (String t : tokens) {
                sb.append(t.concat(" more "));
            }
        } catch (NullPointerException e){}

        return sb.toString();
    }

    @RequestMapping("/ba/stringTheory")
    static public String stringTheory(){
        String oneMillionHello = "";
        for (int i = 0; i < 1000000; i++) {
            oneMillionHello = oneMillionHello + "Hello!";
        }

        return oneMillionHello.substring(0, 6);
    }

    @RequestMapping("/ba/leaky")
    static public String leaky(){
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        final Deque<BigDecimal> numbers = new LinkedBlockingDeque<>();
        final BigDecimal divisor = new BigDecimal(51);
        final StringBuffer sb = new StringBuffer();

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            BigDecimal number = numbers.peekLast();
            if (number != null && number.remainder(divisor).byteValue() == 0) {
                sb.append("Number: " + number);
                sb.append("Deque size: " + numbers.size());
            }
        }, 10, 10, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            numbers.add(new BigDecimal(System.currentTimeMillis()));
        }, 10, 10, TimeUnit.MILLISECONDS);

        try {
            scheduledExecutorService.awaitTermination(1, TimeUnit.DAYS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @RequestMapping("/ba/popularityContest")
    static public String popularityContest(){
        List<String> hats = new ArrayList<>();
        hats.add("Ushanka"); // that one has ear flaps
        hats.add("Fedora");
        hats.add("Sombrero");
        for (String hat : hats) {
            if (hat == "Ushanka") {
                hats.remove(hat);
            }
        }

        return hats.toString();
    }

    public class Apple {
        public String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Apple apple = (Apple) o;

            return Objects.equals(name, apple.name);
        }

        @Override
        public int hashCode() {
            return (int) (Math.random() * 5000);
        }
    }
}


