package edu.eci.arsw.blueprints.services.filter;

import edu.eci.arsw.blueprints.model.Point;

/**
 * BlueprintFilter
 */
public interface BlueprintFilter {
    Point[] filter(Point[] points);
}