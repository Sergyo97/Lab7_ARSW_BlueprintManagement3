package edu.eci.arsw.blueprints.services.filter.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.filter.BlueprintFilter;

/**
 * SubsamplingFiltering
 */
@Component
public class SubsamplingFiltering implements BlueprintFilter {

    @Override
    public Point[] filter(Point[] points) {
        ArrayList<Point> newPoints = new ArrayList<>();
        for (int i = 0; i < (points.length) - 1; i++) {
            if (i % 2 == 0) {
                newPoints.add(points[i]);
            }
        }
        Point[] np = new Point[newPoints.size()];
        for (int i = 0; i < newPoints.size(); i++) {
            np[i] = newPoints.get(i);
        }
        return np;
    }

}