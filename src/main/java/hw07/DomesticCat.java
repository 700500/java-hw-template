package hw07;

import java.util.Arrays;

public class DomesticCat extends Pet implements SpecialMethod {


    DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super( nickname, age, trickLevel, habits);
    }



    @Override
    public String toString(){
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                Species.DomesticCat.name(), getNickname(), getAge(), getTrickLevel(), Arrays.toString(getHabits()));
    }

    @Override
    public void respond() {
        System.out.printf("Hello owner. I am - %s\n",getNickname());
    }

    @Override
    public String trickLevel(int trickLevel) {
        if (trickLevel > 50) {
            return "He is very sly";
        } else
            return "He is almost not sly";
    }

    @Override
    public void foul() {
        System.out.print("I need to cover it up\n");
    }
}