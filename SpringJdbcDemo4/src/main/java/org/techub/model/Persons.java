package org.techub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persons {
    private String personID;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
}
