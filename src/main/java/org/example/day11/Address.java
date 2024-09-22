package org.example.day11;

public record Address(String city, String state) {
}

//public final class Address {
//    private String city;
//    private String state;
//
//    public Address(String city, String state) {
//        this.city = city;
//        this.state = state;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                '}';
//    }
//}
