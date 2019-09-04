package edu.eci.arsw.blueprints.services.filter;

import java.util.ArrayList;
import java.util.List;

import edu.eci.arsw.blueprints.model.Point;

/**
 * BlueprintFilter
 */
public interface BlueprintFilter {
    ArrayList<Point> filter(List<Point> points);
}