/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 *
 * @author hcadavid
 */
@Component
public class InMemoryBlueprintPersistence implements BlueprintsPersistence {

    private final Map<Tuple<String, String>, Blueprint> blueprints = new HashMap<>();

    public InMemoryBlueprintPersistence() {
        // load stub data
        Point[] pts = new Point[] { new Point(140, 140), new Point(115, 115) };
        Blueprint bp = new Blueprint("David", "El I", pts);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);

        Point[] pts1 = new Point[] { new Point(140, 140), new Point(115, 115), new Point(115, 123),
                new Point(215, 115) };
        Blueprint bp1 = new Blueprint("David", "El F", pts1);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp1);

        Point[] pts2 = new Point[] { new Point(140, 140), new Point(115, 115), new Point(115, 11), new Point(115, 15),
                new Point(115, 5) };
        Blueprint bp2 = new Blueprint("El toro Aurelio", "El H", pts2);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp2);

    }

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(), bp.getName()))) {
            throw new BlueprintPersistenceException("The given blueprint already exists: " + bp);
        } else {
            blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        }
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        return blueprints.get(new Tuple<>(author, bprintname));
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> blueprintSet = new HashSet<>();
        for (Blueprint blp : blueprints.values()) {
            if (blp.getAuthor().equals(author)) {
                blueprintSet.add(blp);
            }
        }
        if (blueprintSet.isEmpty()) {
            throw new BlueprintNotFoundException("There is no blueprints registered by " + author);
        }
        return blueprintSet;
    }

}
