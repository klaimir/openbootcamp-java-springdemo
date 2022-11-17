package com.openbootcamp.java.demo.controllers;

import com.openbootcamp.java.demo.models.Bootcamper;
import com.openbootcamp.java.demo.services.BootcamperService;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcampersControllers {

    private final BootcamperService bootcamperService;

    // Inyección de dependencias
    // Filosofía similar a la inyección de dependencias de los componentes de angular
    public BootcampersControllers(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add(new Bootcamper("Bootcamper1", 1));
        this.bootcamperService.add(new Bootcamper("Bootcamper2", 2));
        this.bootcamperService.add(new Bootcamper("Bootcamper3", 3));
    }

    @GET
    public String hola() {
        return "Hola";
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listarTodos() {
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper getBootcamper(@PathParam("nombre") String nombre) {
        return bootcamperService.find(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);

        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getNombre())
        ).build();
    }
}
