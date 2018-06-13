import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {
    public static void main(String args[]) {
        Graph graph = new SingleGraph("Test 1");
        //Example 1
//        graph.addNode("A" );
//        graph.addNode("B" );
//        graph.addNode("C" );
//        graph.addEdge("AB", "A", "B");
//        graph.addEdge("BC", "B", "C");
//        graph.addEdge("CA", "C", "A");

        //Example2
        graph.addNode("A" );
        graph.addNode("B" );
        graph.addNode("C" );
        graph.addNode("D" );
        graph.addNode("E" );
        graph.addNode("F" );
        graph.addNode("G" );
        graph.addNode("H" );
        graph.addNode("I" );

        graph.addEdge("AC", "A", "C");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CD", "C", "D");
        graph.addEdge("CE", "C", "E");
        graph.addEdge("DF", "D", "F");
        graph.addEdge("EF", "E", "F");
        graph.addEdge("EG", "E", "G");
        graph.addEdge("FH", "F", "H");
        graph.addEdge("GH", "G", "H");
        graph.addEdge("HI", "H", "I");

        //graph.display();

        System.out.println("--------------Basic graph---------------");

        VitalityIndex vitalityIndex = new VitalityIndex("closeness", VitalityIndex.NormalizationMode.NONE);
        vitalityIndex.init(graph);
        vitalityIndex.computeCentrality();


        Graph graphSecond = graph;
        //input id of node like a parameter in method below which you want calculate vitality index for them
        graphSecond.removeNode("A");

        System.out.println("---------Graph after remove node--------");

        VitalityIndex vitalityIndex2 = new VitalityIndex("closeness", VitalityIndex.NormalizationMode.NONE);
        vitalityIndex2.init(graphSecond);
        vitalityIndex2.computeCentrality();

        System.out.println("\n");
        System.out.println("-----Vitality index like difference-----");
        System.out.println("Vitality index " +(vitalityIndex.wienerIndex - vitalityIndex2.wienerIndex)  );
        System.out.println("------Vitality index like quotient------");
        System.out.println("Vitality index " +((double)vitalityIndex.wienerIndex/(double)vitalityIndex2.wienerIndex)  );


    }
}
