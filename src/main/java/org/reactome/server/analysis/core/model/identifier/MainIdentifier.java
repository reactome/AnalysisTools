package org.reactome.server.analysis.core.model.identifier;

import org.reactome.server.analysis.core.model.AnalysisIdentifier;
import org.reactome.server.analysis.core.model.resource.MainResource;
import org.reactome.server.analysis.core.model.resource.ResourceFactory;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class MainIdentifier extends Identifier<MainResource> {

    public MainIdentifier(MainResource resource, AnalysisIdentifier identifier) {
        super(resource, identifier);
    }

    public MainIdentifier(MainResource resource, String identifier, List<Double> exp){
        super(resource, new AnalysisIdentifier(identifier, exp));
    }

    //Creates a clone
    public MainIdentifier(MainIdentifier mainIdentifier){
        super(mainIdentifier.resource, new AnalysisIdentifier(mainIdentifier.value));
    }

    public boolean is(ResourceFactory.MAIN type){
        return this.is(type.name());
    }

}
