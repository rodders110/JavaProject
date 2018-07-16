package controllers;


import db.DBHelper;
import models.Paddock;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class PaddockController {

    public PaddockController(){
        this.setupEndPoints();
    }

    private void setupEndPoints(){

    get("/paddocs", (res, req) -> {
        HashMap<String, Object> model = new HashMap<>();
        List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
        model.put("template", "paddocks/index.vtl");
        model.put("paddocks", paddocks);
        return new ModelAndView(model, "layout.vtl");
        },new VelocityTemplateEngine());
    }
}