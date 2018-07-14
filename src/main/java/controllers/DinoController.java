package controllers;

import db.DBHelper;
import models.Dinosaur;
import models.Paddock;
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
            return new ModelAndView(model, "layout.vtl");

        }, new VelocityTemplateEngine());

        get("/dinosaurs/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("paddocks", paddocks);
            model.put("template", "dinosaurs/create.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
