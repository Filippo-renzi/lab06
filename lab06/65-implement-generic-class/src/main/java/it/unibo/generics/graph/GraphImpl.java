package it.unibo.generics.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Node;

import it.unibo.generics.graph.api.Graph;



public class GraphImpl<N> implements Graph{

    private List<Object> node;
    private String target;
    private String source;

    public GraphImpl(){this.node = new LinkedList<>();}

    @Override
    public void addNode(Object node) {
        this.node.add(node);
    }

    @Override
    public void addEdge(Object source, Object target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public Set nodeSet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodeSet'");
    }

    @Override
    public Set linkedNodes(Object node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List getPath(Object source, Object target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
   
    
}