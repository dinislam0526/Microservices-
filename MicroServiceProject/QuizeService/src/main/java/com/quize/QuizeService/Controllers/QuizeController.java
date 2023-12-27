package com.quize.QuizeService.Controllers;

import com.quize.QuizeService.Entity.Quize;
import com.quize.QuizeService.Services.QuizeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizeController {

    private QuizeService quizeService;

    public QuizeController(QuizeService quizeService) {
        this.quizeService = quizeService;
    }

    @PostMapping("/save")
    public Quize add(@RequestBody Quize quize){
        return quizeService.add(quize);
    }

    @GetMapping("/getAll")
    public List<Quize> getAll(){
        return quizeService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Quize getById(@PathVariable Long id){
        return quizeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Quize update(@PathVariable("id") Long id, @RequestBody Quize employee) {
        return quizeService.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return quizeService.delete(id);
    }
}
