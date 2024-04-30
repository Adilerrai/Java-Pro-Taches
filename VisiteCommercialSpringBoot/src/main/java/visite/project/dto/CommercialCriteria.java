package visite.project.dto;

import visite.project.model.Visite;

import java.util.List;
 public class CommercialCriteria {

        private String name;
        private String address;
        private String phoneNumber;
        private List<Visite> visites;


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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

