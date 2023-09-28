package sn.policestation.tioybi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(name = "region")
    private String region;

    @Column(name = "department")
    private String department;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "phonenumber")
    private int phoneNumber;

}
