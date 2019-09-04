package edu.eci.arsw.blueprints.services.filter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.filter.BlueprintFilter;

/**
 * RedundancyFiltering
 */
@Component
public class RedundancyFiltering implements BlueprintFilter {

    @Override
    public ArrayList<Point> filter(List<Point> P) {
        ArrayList<Point> points = new ArrayList<Point>();
        points.addAll(P);
        ArrayList<Point> newPoints = new ArrayList<Point>();
        for (int i = 0; i < points.size(); i++) {
            newPoints.add(points.get(i));
            if(i+1 < points.size() && points.get(i).equals(points.get(i+1))){
                i++;
            }
        }
        return newPoints;
    }

}