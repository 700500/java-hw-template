package hw10.domain;


import hw10.domain.Human;

import java.util.Map;

public final class Woman extends Human {

    public Woman(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    void makeup(){
        System.out.print("My makeup\n");
    }

}
