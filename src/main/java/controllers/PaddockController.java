package controllers;


import db.DBHelper;
import models.Paddock;
import models.Park;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class PaddockController {

    public PaddockController(){
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/paddocks", (res, req) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
            model.put("template", "paddock/index.vtl");
            model.put("paddocks", paddocks);
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());


        get("/paddocks/newPaddock", (res, req) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("template", "paddock/newPaddock.vtl");
            model.put("parks", parks);
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());

        post("/paddock/paddock/new", (req, res) -> {
            int parkId = Integer.parseInt(req.queryParams("park_id"));
            int newPadNum = Integer.parseInt(req.queryParams("pad_num"));
            Park park = DBHelper.find(Park.class, parkId);
            Paddock newPad = new Paddock(newPadNum);
            newPad.setPark(park);
            DBHelper.save(newPad);
            res.redirect("/paddocks");
            return null;
        },new VelocityTemplateEngine());

    }
}
