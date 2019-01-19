package model;

import annotation.Autowired;
import annotation.Bean;
import annotation.Value;

@Bean
public class Card {

    @Value("0000")
    private String id;

    @Value("Dainy")
    private String name;

    @Value("Mars")
    private String address;

    @Autowired
    private Phone phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 17:13
 **/
