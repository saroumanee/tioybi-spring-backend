package sn.policestation.tioybi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.policestation.tioybi.entity.PoliceStation;

public interface IPoliceStationRepo extends JpaRepository<PoliceStation, Long> {

}
