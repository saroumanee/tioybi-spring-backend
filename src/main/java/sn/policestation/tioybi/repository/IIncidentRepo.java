package sn.policestation.tioybi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.policestation.tioybi.entity.Incident;

public interface IIncidentRepo extends JpaRepository<Incident, Long> {

}
