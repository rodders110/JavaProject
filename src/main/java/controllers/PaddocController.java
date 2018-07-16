package controllers;


import db.DBHelper;
import models.Paddock;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class PaddocController {

    public PaddocController){
        this.setupEndPoints();
    }

    private void setupEndPoints{

    get("/paddocs", (res, req) -> {
        HashMap<String, Object> model = new HashMap<>();
        List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
        model.put(("template", "paddocks/"))

        }new VelocityTemplateEngine());
    }
}
