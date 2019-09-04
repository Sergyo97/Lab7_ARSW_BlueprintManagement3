package edu.eci.arsw.blueprints.services.filter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.filter.BlueprintFilter;

/**
 * SubsamplingFiltering
 */
@Component
public class SubsamplingFiltering implements BlueprintFilter {

    @Override
    public ArrayList<Point> filter(List<Point> P) {
        ArrayList<Point> points = new ArrayList<Point>();
        points.addAll(P);
        ArrayList<Point> newPoints = new ArrayList<Point>();
        for (int i = 0; i < (points.size()) - 1; i++) {
            if (i % 2 == 0) {
                newPoints.add(points.get(i));
            }
        }
        return newPoints;
    }

}