package com.gaming.lab.data;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class LabInfo {

    public LabCity lab;

    public enum LabCity{
        AMMAN("Amman", "Amman - Alhussien Business park", "https://goo.gl/maps/eLSAQXjg1mw", "info@gaminglab.com", "0799293605", "#FBE232"),
        ZARQA("Zarqa", "Zarqa - Zarqa Chamber of Industry", "https://goo.gl/maps/Aq9cF9xreXx", "zarqa@gaminglab.com", "0798548685", "#AEB139"),
        AQABA("Aqaba", "Aqaba - Al-Quds Street", "https://goo.gl/maps/J6vBCJg86GU2", "aqaba@gaminglab.com", "0799293563", "#76046E"),
        IRBID("Irbid", "Irbid - Ramtha", "https://goo.gl/maps/UKXdNB1GAsL2", "irbid@gaminglab.com", "0799293546", "#0076BA"),
        MAAN("Ma'an", "Ma'an - Alhussien Bin Talal University", "https://goo.gl/maps/LYq6LhUDDKx", "maan@gaminglab.com", "0791125792", "#DD8201"),
        KARAK_C("Karak - Creativity Club", "Karak, Al Marj", "https://goo.gl/maps/WKoyU6yFCyt", "karak.c@gaminglab.com", "0797150791", "#CB2A7B"),
        KARAK_M("Karak - Muta University", "Karak - Muta University", "https://goo.gl/maps/3T42Jrg8kGq", "karak.m@gaminglab.com", "0797153573", "#298B20");

        private String city;
        private String location;
        private String locationLink;
        private String email;
        private String phone;
        private String color;

        LabCity(String city, String location, String locationLink, String email, String phone, String color)
        {
            this.city = city;
            this.location = location;
            this.locationLink = locationLink;
            this.email = email;
            this.phone = phone;
            this.color = color;
        }

        public String getLocation() {
            return location;
        }

        public String getLocationLink() {
            return locationLink;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getCity(){
            return this.city;
        }

        public String getColor() {
            return color;
        }
    }

}
