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

import sn.policestation.tioybi.entity.Policeman;
import sn.policestation.tioybi.exception.NotFoundException;
import sn.policestation.tioybi.repository.IPolicemanRepo;

@RestController
@RequestMapping("/policeman")
@CrossOrigin
public class PolicemanController {

    @Autowired
    private IPolicemanRepo iPolicemanRepo;

    @GetMapping("/list")
    public ResponseEntity<List<Policeman>> getPolicemen() {
        List<Policeman> policemen = iPolicemanRepo.findAll();
        return new ResponseEntity<>(policemen, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policeman> getPolicemanById(@PathVariable("id") Long id) {
        Policeman policeman = iPolicemanRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        return new ResponseEntity<>(policeman, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Policeman> savePoliceman(@RequestBody Policeman policeman) {
        iPolicemanRepo.save(policeman);
        return new ResponseEntity<>(policeman, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Policeman> updatePoliceman(@RequestBody Policeman policeman) {
        iPolicemanRepo.save(policeman);
        return new ResponseEntity<>(policeman, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Policeman> deletePoliceman(@PathVariable("id") Long id) {
        Policeman guilty = iPolicemanRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        iPolicemanRepo.delete(guilty);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
