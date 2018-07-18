package controllers;


import db.DBHelper;
import db.DBPaddock;
import models.Paddock;
import models.Park;
import models.Visitor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static spark.Spark.get;
import static spark.Spark.post;

public class PaddockController {

    public PaddockController(){
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/paddocks", (res, req) -> {
            randomRampage();
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


        post("/paddock/:id/delete", (req, res) -> {
            int paddockId = Integer.parseInt(req.params(":id"));
            Paddock newPad = DBHelper.find(Paddock.class, paddockId);
            DBHelper.delete(newPad);
            res.redirect("/paddocks");
            return null;
        },new VelocityTemplateEngine());

        post("/paddock/:id/repair", (req, res) -> {
            int paddockId = Integer.parseInt(req.params(":id"));
            Paddock newPad = DBHelper.find(Paddock.class, paddockId);
            newPad.setIntegrity(100);
            DBHelper.update(newPad);
            res.redirect("/paddocks");
            return null;
        },new VelocityTemplateEngine());

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

    public static void randomRampage(){
        List<Paddock> paddocks = DBHelper.getAll(Paddock.class);
        Random r = new Random();
        int index = r.nextInt(paddocks.size() - 1);
        paddocks.get(index).rampage();
    }
}
