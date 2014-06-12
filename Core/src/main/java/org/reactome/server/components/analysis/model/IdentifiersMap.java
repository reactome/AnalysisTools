package org.reactome.server.components.analysis.model;

import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.NodeFactory;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharSequenceNodeFactory;
import org.reactome.server.components.analysis.model.resource.Resource;
import org.reactome.server.components.analysis.util.MapSet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class IdentifiersMap implements Serializable {

    private RadixTree<MapSet<Resource, PhysicalEntityNode>> tree;

    public IdentifiersMap() {
        NodeFactory nodeFactory = new DefaultCharSequenceNodeFactory();
        this.tree = new ConcurrentRadixTree<MapSet<Resource, PhysicalEntityNode>>(nodeFactory);
    }

    private MapSet<Resource, PhysicalEntityNode> getOrCreateResourceEntitiesMap(String identifier){
        MapSet<Resource, PhysicalEntityNode> map = this.tree.getValueForExactKey(identifier);
        if(map==null){
            map = new MapSet<Resource, PhysicalEntityNode>();
            this.tree.put(identifier, map);
        }
        return map;
    }

    public void add(String identifier, Resource resource, PhysicalEntityNode node){
        String id = identifier.trim().toUpperCase();
//        String id = identifier.trim();
        MapSet<Resource, PhysicalEntityNode> map = getOrCreateResourceEntitiesMap(id);
        map.add(resource, node);
    }

    public MapSet<Resource, PhysicalEntityNode> get(AnalysisIdentifier identifier){
        String id = identifier.getId().toUpperCase();
//        String id = identifier.getId();
        MapSet<Resource, PhysicalEntityNode> rtn = this.tree.getValueForExactKey(id);
        if(rtn==null){
            rtn = new MapSet<Resource, PhysicalEntityNode>();
        }
        return rtn;
    }

    /**
     * Returns all the identifiers in the Map (upper Case)
     * @return all the identifiers in the Map (upper Case)
     */
    public Set<String> keySet(){
        Set<String> keySet = new HashSet<String>();
        for (CharSequence charSequence : this.tree.getKeysStartingWith("")) {
            keySet.add(String.valueOf(charSequence));
        }
        return keySet;
    }
}