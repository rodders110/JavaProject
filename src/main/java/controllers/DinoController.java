package controllers;

import db.DBHelper;
import models.Dinosaur;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class DinoController {

    public DinoController(){
        this.setupEndPoints();
    }

    private void setupEndPoints(){

        get("/dinosaurs", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);
            model.put("template", "dinosaurs/index.vtl");
            model.put("dinosaurs", dinosaurs);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());
    }
}
