package it.unibo.generics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private Map<N,List<N>> objectmap;

    public GraphImpl(){
        this.objectmap = new HashMap<>();
    }

    @Override
    public void addNode(N node) {
        if(node == null ||objectmap.containsKey(node)){return ;}
       this.objectmap.put(node, new LinkedList<>());
    }

    @Override
    public void addEdge(N source, N target) {
        if(source == null || target == null){return ;}
        if(!objectmap.containsKey(source)){return ;}
        objectmap.get(source).add(target);
    }

    @Override
    public Set nodeSet() {
        return this.objectmap.keySet();
    }

    @Override
    public Set linkedNodes(N node) {
        if(this.objectmap.containsKey(node)){
            return new HashSet<N>(objectmap.get(node));
        }
        return null;
    }

    @Override
    public List getPath(N source, N target) {
       List<N> path = new LinkedList<>();
        
        // 1. Controlli preliminari: se i nodi sono nulli o non esistono nel grafo, non c'è cammino
        if (source == null || target == null || !objectmap.containsKey(source) || !objectmap.containsKey(target)) {
            return path;
        }

        // Se sorgente e destinazione coincidono, il percorso è solo il nodo stesso
        if (source.equals(target)) {
            path.add(source);
            return path;
        }

        // Strutture dati per la BFS (Visita in ampiezza)
        Queue<N> queue = new LinkedList<>();
        Map<N, N> parentMap = new HashMap<>(); // Serve per ricordarci da dove siamo arrivati
        Set<N> visited = new HashSet<>();     // Evita di visitare lo stesso nodo due volte

        queue.add(source);
        visited.add(source);

        boolean found = false;

        while (!queue.isEmpty()) {
            N current = queue.poll();

            // Se abbiamo raggiunto il target, interrompiamo la ricerca
            if (current.equals(target)) {
                found = true;
                break;
            }

            // Esploriamo tutti i nodi collegati (vicini)
            Set<N> neighbors = linkedNodes(current);
            if (neighbors != null) {
                for (N neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        parentMap.put(neighbor, current); // Ricordiamo che a 'neighbor' siamo arrivati da 'current'
                        queue.add(neighbor);
                    }
                }
            }
        }

        // Se non abbiamo trovato alcuna strada, restituiamo una lista vuota
        if (!found) {
            return path;
        }

        // 2. Ricostruzione del percorso a ritroso (dal target alla source)
        N curr = target;
        while (curr != null) {
            path.add(0, curr); // Aggiungiamo in testa per invertire l'ordine corretto
            curr = parentMap.get(curr);
        }

        return path;
    }
}
