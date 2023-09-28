package sn.policestation.tioybi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.policestation.tioybi.entity.Guilty;

public interface IGuiltyRepo extends JpaRepository<Guilty, Long> {

}
