package edu.eci.arsw.blueprints;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {

    public static void main(String[] args) throws BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices blps = ac.getBean(BlueprintsServices.class);
        Blueprint bp = new Blueprint("David", "El toro Aurelio");
        blps.addNewBlueprint(bp);
        System.out.println(blps.getBlueprintsByAuthor("David"));
    }
}