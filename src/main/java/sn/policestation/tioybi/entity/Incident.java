package sn.policestation.tioybi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Incident extends AbstractEntity {

    @Column(name = "category")
    private String category;

    @Column(name = "typeofincident")
    private String typeOfIncident;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @ManyToMany
    private List<Guilty> guilties;

    @ManyToOne
    private Policeman policeman;

}
