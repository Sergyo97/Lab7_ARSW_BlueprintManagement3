package edu.eci.arsw.blueprints.services.filter;

import java.util.Set;

import edu.eci.arsw.blueprints.model.Blueprint;

/**
 * BlueprintFilter
 */
public interface BlueprintFilter {
    Set< Blueprint> filter(Set<Blueprint> blueprints);
}