package edu.eci.arsw.blueprints.services.filter.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.filter.BlueprintFilter;

/**
 * RedundancyFiltering
 */
@Component
public class RedundancyFiltering implements BlueprintFilter {

    @Override
    public Point[] filter(Point[] points) {
        ArrayList<Point> newPoints = new ArrayList<Point>();
        for (int i = 0; i < (points.length) - 1; i++) {
            if (!points[i].toString().equals(points[i + 1].toString())) {
                System.out.println("NO ENTRO");
                newPoints.add(points[i]);
                if (i == (points.length) - 2) {
                    newPoints.add(points[i]);
                }
            }
        }
        Point[] np = new Point[newPoints.size()];
        for (int i = 0; i < newPoints.size(); i++) {
            np[i] = newPoints.get(i);
        }
        return np;
    }

}