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

import sn.policestation.tioybi.exception.NotFoundException;
import sn.policestation.tioybi.entity.Guilty;
import sn.policestation.tioybi.repository.IGuiltyRepo;

@RestController
@RequestMapping("/guilty")
@CrossOrigin
public class GuiltyController {

    @Autowired
    private IGuiltyRepo iGuiltyRepo;

    @GetMapping("/list")
    public ResponseEntity<List<Guilty>> getGuiltys() {
        List<Guilty> Guiltys = iGuiltyRepo.findAll();
        return new ResponseEntity<>(Guiltys, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guilty> getGuiltyById(@PathVariable("id") Long id) {
        Guilty Guilty = iGuiltyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        return new ResponseEntity<>(Guilty, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Guilty> saveGuilty(@RequestBody Guilty guilty) {
        iGuiltyRepo.save(guilty);
        return new ResponseEntity<>(guilty, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Guilty> updateGuilty(@RequestBody Guilty guilty) {
        iGuiltyRepo.save(guilty);
        return new ResponseEntity<>(guilty, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Guilty> deleteGuilty(@PathVariable("id") Long id) {
        Guilty guilty = iGuiltyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entity by id" + id + " was not foud"));
        iGuiltyRepo.delete(guilty);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
