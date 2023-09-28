package sn.policestation.tioybi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.policestation.tioybi.entity.Policeman;

public interface IPolicemanRepo extends JpaRepository<Policeman, Long> {

}
