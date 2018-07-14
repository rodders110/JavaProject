package controllers;

import db.DBHelper;
import db.Seeds;
import models.Park;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;


import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class ParkController {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/resources");
        Seeds.seedData();
        DinoController dinoController = new DinoController();


        List<Park> parks = DBHelper.getAll(Park.class);


        get ("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("parks", parks);
            model.put("template", "park/index.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

    }
}
