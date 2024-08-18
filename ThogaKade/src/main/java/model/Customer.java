package model;

import lombok.*;

import java.time.LocalDate;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Customer {
    private String id;
    private String name;
    private String address;
    private String title;
    private LocalDate dob;
    private String contactNumber;

    public Customer(String id, String title, String name, String address, String contactNumber, LocalDate dob) {
        this.id = id;
        this.title=title;
        this.name =title+name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dob = dob;
    }



}
