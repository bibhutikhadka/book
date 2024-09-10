package models;

public class Customer {
        private String name;
        private String email;
        private String city;
        private String residentNo;
        public int orderCount;

        public Customer(String name, String email, String city, String residentNo, int orderCount) {
            this.name = name;
            this.email = email;
            this.city = city;
            this.residentNo = residentNo;
            this.orderCount = orderCount;
        }

        public String getName() {
            return name;
        }
    }



