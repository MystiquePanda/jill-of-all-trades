package com.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    @RequestMapping("/ba/stringTheory")
    static public String stringTheory(){
        List<String> tokens = rarelyValidList();
        StringBuilder sb = new StringBuilder();
        for (String t : Objects.requireNonNull(tokens)) {
            sb.append(t.concat(" more "));
        }

        return sb.toString();
    }

}
