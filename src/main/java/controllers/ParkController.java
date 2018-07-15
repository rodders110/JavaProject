package controllers;

import db.DBHelper;
import db.DBPaddock;
import db.DBPark;
import db.Seeds;
import models.Paddock;
import models.Park;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;
import static spark.route.HttpMethod.get;

public class ParkController {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/resources");
        Seeds.seedData();
        DinoController dinoController = new DinoController();





        get ("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Park> parks = DBHelper.getAll(Park.class);
            model.put("parks", parks);
            model.put("template", "park/index.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/park/:id/newPaddock", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "paddock/index.vtl");
            model.put("id", id);
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/park/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "park/create.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);


        post("/park/new", (req, res) -> {
            String name = req.queryParams("name");
            Park newPark = new Park(name);
            DBHelper.save(newPark);
            res.redirect("/");
            return null;
        }, velocityTemplateEngine);

        get("/park/:id/update", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Park park = DBHelper.find(Park.class, id);
            List<Paddock> paddocks = DBPaddock.allPaddocks(park);
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "park/update.vtl");
            model.put("park", park);
            model.put("paddocks", paddocks);
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        post("/park/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Park park = DBHelper.find(Park.class, id);
            DBHelper.delete(park);
            res.redirect("/");
            return null;
        }, velocityTemplateEngine);

        post("/park/:id/update", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            String newName = req.queryParams("name");
            Park park = DBHelper.find(Park.class, id);
            park.setName(newName);
            DBHelper.update(park);
            res.redirect("/");
            return null;
        }, velocityTemplateEngine);

    }
}
