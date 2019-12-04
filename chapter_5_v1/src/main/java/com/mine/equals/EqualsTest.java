package com.mine.equals;

import org.junit.jupiter.api.Test;

public class EqualsTest {


    @Test
    public void method1(){
        Human[] humans = {new Human("王五"),new Man("王五"),new Man("王五")};
        System.out.println(humans[0].equals(humans[1]));
        System.out.println(humans[1].equals(humans[2]));
    }
}
