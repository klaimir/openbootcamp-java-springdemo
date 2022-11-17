package com.openbootcamp.java.demo.services;

import com.openbootcamp.java.demo.models.Bootcamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BootcamperService {

    private List<Bootcamper> bootcampers = new ArrayList<>();

    public List<Bootcamper> getAll() {
        return bootcampers;
    }

    public void add(Bootcamper bootcamper) {
        bootcampers.add(bootcamper);
    }

    public Bootcamper find(String nombre) {
        Optional<Bootcamper> resultado = bootcampers.stream().filter((bootcamper -> bootcamper.getNombre().equals(nombre))).findFirst();
        return resultado.isEmpty() ? null : resultado.get();
    }
}
