package sn.policestation.tioybi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.policestation.tioybi.entity.PoliceStation;
import sn.policestation.tioybi.exception.NotFoundException;
import sn.policestation.tioybi.repository.IPoliceStationRepo;

@RestController
@RequestMapping("/policestation")
@CrossOrigin
public class PoliceStationController {

    @Autowired
    private IPoliceStationRepo iPoliceStationRepo;

    @GetMapping("/list")
    public ResponseEntity<List<PoliceStation>> getPoliceStations() {
        List<PoliceStation> policeStations = iPoliceStationRepo.findAll();
        return new ResponseEntity<>(policeStations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliceStation> getPoliceStationById(@PathVariable("id") Long id) {
        PoliceStation policeStation = iPoliceStationRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        return new ResponseEntity<>(policeStation, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<PoliceStation> savePoliceStation(@RequestBody PoliceStation policeStation) {
        iPoliceStationRepo.save(policeStation);
        return new ResponseEntity<>(policeStation, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PoliceStation> updatePoliceStation(@RequestBody PoliceStation policeStation) {
        iPoliceStationRepo.save(policeStation);
        return new ResponseEntity<>(policeStation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PoliceStation> deletePoliceStation(@PathVariable("id") Long id) {
        PoliceStation policeStation = iPoliceStationRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        iPoliceStationRepo.delete(policeStation);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
