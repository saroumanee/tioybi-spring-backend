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

import sn.policestation.tioybi.entity.Incident;
import sn.policestation.tioybi.exception.NotFoundException;
import sn.policestation.tioybi.repository.IIncidentRepo;

@RestController
@RequestMapping("/incident")
@CrossOrigin
public class IncidentController {

    @Autowired
    private IIncidentRepo iIncidentRepo;

    @GetMapping("/list")
    public ResponseEntity<List<Incident>> getIncidents() {
        List<Incident> incidents = iIncidentRepo.findAll();
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable("id") Long id) {
        Incident incident = iIncidentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        return new ResponseEntity<>(incident, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Incident> saveIncident(@RequestBody Incident incident) {
        iIncidentRepo.save(incident);
        return new ResponseEntity<>(incident, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Incident> updateIncident(@RequestBody Incident incident) {
        iIncidentRepo.save(incident);
        return new ResponseEntity<>(incident, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Incident> deleteIncident(@PathVariable("id") Long id) {
        Incident incident = iIncidentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        iIncidentRepo.delete(incident);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
