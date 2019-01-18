package model;

import annotation.Bean;
import annotation.Value;

@Bean
public class Phone {

    @Value("2.33")
    String screen;

    String brand;

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 17:50
 **/
