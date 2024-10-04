import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
    	String A = "input-A.txt";
    	new CompetitionDijkstra(A, 60, 70, 90);
    	String nullFilename = null;
    	new CompetitionDijkstra(nullFilename, 60, 80, 90);
    	String wrongFilename = "A.txt";
    	new CompetitionDijkstra(wrongFilename, 60, 80, 90);
    }
    
    @Test
    public void testFWConstructor() {
    	String A = "input-A.txt";
    	new CompetitionFloydWarshall(A, 60, 70, 90);
    	String nullFilename = null;
    	new CompetitionFloydWarshall(nullFilename, 60, 80, 90);
    	String wrongFilename = "A.txt";
    	new CompetitionDijkstra(wrongFilename, 60, 80, 90);
    }
    
    @Test
    public void testWrongSpeeds() {
    	String A = "input-A.txt";
    	CompetitionDijkstra wrongSpeeds1D = new CompetitionDijkstra(A, 2, 70, 70);
    	CompetitionDijkstra wrongSpeeds2D = new CompetitionDijkstra(A, 200, 70, 70);
    	CompetitionDijkstra wrongSpeeds3D = new CompetitionDijkstra(A, 70, 2, 70);
    	CompetitionDijkstra wrongSpeeds4D = new CompetitionDijkstra(A, 70, 200, 70);
    	CompetitionDijkstra wrongSpeeds5D = new CompetitionDijkstra(A, 70, 70, 2);
    	CompetitionDijkstra wrongSpeeds6D = new CompetitionDijkstra(A, 70, 70, 200);
    	assertEquals("Testing file A with wrong speeds: 2, 70, 70", -1, wrongSpeeds1D.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 200, 70, 70", -1, wrongSpeeds2D.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 2, 70", -1, wrongSpeeds3D.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 200, 70", -1, wrongSpeeds4D.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 70, 2", -1, wrongSpeeds5D.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 70, 200", -1, wrongSpeeds6D.timeRequiredforCompetition());
    	CompetitionFloydWarshall wrongSpeeds1FW = new CompetitionFloydWarshall(A, 2, 70, 70);
    	CompetitionFloydWarshall wrongSpeeds2FW = new CompetitionFloydWarshall(A, 200, 70, 70);
    	CompetitionFloydWarshall wrongSpeeds3FW = new CompetitionFloydWarshall(A, 70, 2, 70);
    	CompetitionFloydWarshall wrongSpeeds4FW = new CompetitionFloydWarshall(A, 70, 200, 70);
    	CompetitionFloydWarshall wrongSpeeds5FW = new CompetitionFloydWarshall(A, 70, 70, 2);
    	CompetitionFloydWarshall wrongSpeeds6FW = new CompetitionFloydWarshall(A, 70, 70, 200);
    	assertEquals("Testing file A with wrong speeds: 2, 70, 70", -1, wrongSpeeds1FW.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 200, 70, 70", -1, wrongSpeeds2FW.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 2, 70", -1, wrongSpeeds3FW.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 200, 70", -1, wrongSpeeds4FW.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 70, 2", -1, wrongSpeeds5FW.timeRequiredforCompetition());
    	assertEquals("Testing file A with wrong speeds: 70, 70, 200", -1, wrongSpeeds6FW.timeRequiredforCompetition());
    }
    
    @Test
    public void testDijkstra() {
    	String A = "input-A.txt";
    	String B = "input-B.txt";
    	String C = "input-C.txt";
    	String D = "input-D.txt";
    	String E = "input-E.txt";
    	String F = "input-F.txt";
    	String G = "input-G.txt";
    	String I = "input-I.txt";
    	String J = "input-J.txt";
    	String K = "input-K.txt";
    	String L = "input-L.txt";
    	String M = "input-M.txt";
    	String N = "input-N.txt";
    	String tiny = "tinyEWD.txt";
    	CompetitionDijkstra testA = new CompetitionDijkstra(A, 60, 70, 90);
    	CompetitionDijkstra testB = new CompetitionDijkstra(B, 60, 80, 50);
    	CompetitionDijkstra testC = new CompetitionDijkstra(C, 60, 70, 90);
    	CompetitionDijkstra testD = new CompetitionDijkstra(D, 50, 80, 60);
    	CompetitionDijkstra testE = new CompetitionDijkstra(E, 60, 70, 90);
    	CompetitionDijkstra testF = new CompetitionDijkstra(F, 60, 70, 90);
    	CompetitionDijkstra testG = new CompetitionDijkstra(G, 60, 70, 90);
    	CompetitionDijkstra testI = new CompetitionDijkstra(I, 72, 70, 65);
    	CompetitionDijkstra testJ = new CompetitionDijkstra(J, 60, 70, 90);
    	CompetitionDijkstra testK = new CompetitionDijkstra(K, 60, 70, 90);
    	CompetitionDijkstra testL = new CompetitionDijkstra(L, 60, 70, 90);
    	CompetitionDijkstra testM = new CompetitionDijkstra(M, 60, 70, 90);
    	CompetitionDijkstra testN = new CompetitionDijkstra(N, 60, 70, 90);
    	CompetitionDijkstra testTiny = new CompetitionDijkstra(tiny, 60, 70, 90);
    	assertEquals("Testing file A with speeds: 60, 70, 90", -1, testA.timeRequiredforCompetition());
    	assertEquals("Testing file B with speeds: 60, 80, 50", 10000, testB.timeRequiredforCompetition());
    	assertEquals("Testing file C with speeds: 60, 70, 90", -1, testC.timeRequiredforCompetition());
    	assertEquals("Testing file D with speeds: 50, 80, 60", 38, testD.timeRequiredforCompetition());
    	assertEquals("Testing file E with speeds: 60, 70, 90", 24, testE.timeRequiredforCompetition());
    	assertEquals("Testing file F with speeds: 60, 70, 90", -1, testF.timeRequiredforCompetition());
    	assertEquals("Testing file G with speeds: 60, 70, 90", -1, testG.timeRequiredforCompetition());
    	assertEquals("Testing file I with speeds: 72, 70, 65", 185, testI.timeRequiredforCompetition());
    	assertEquals("Testing file J with speeds: 60, 70, 90", -1, testJ.timeRequiredforCompetition());
    	assertEquals("Testing file K with speeds: 60, 70, 90", 267, testK.timeRequiredforCompetition());
    	assertEquals("Testing file L with speeds: 60, 70, 90", 134, testL.timeRequiredforCompetition());
    	assertEquals("Testing file M with speeds: 60, 70, 90", 250, testM.timeRequiredforCompetition());
    	assertEquals("Testing file N with speeds: 60, 70, 90", 134, testN.timeRequiredforCompetition());
    	assertEquals("Testing file tiny with speeds: 60, 70, 90", 31, testTiny.timeRequiredforCompetition());
    }
    
    @Test
    public void testFW() {
    	String A = "input-A.txt";
    	String B = "input-B.txt";
    	String C = "input-C.txt";
    	String D = "input-D.txt";
    	String F = "input-F.txt";
    	String G = "input-G.txt";
    	String I = "input-I.txt";
    	String J = "input-J.txt";
    	String K = "input-K.txt";
    	String L = "input-L.txt";
    	String M = "input-M.txt";
    	String N = "input-N.txt";
    	String tiny = "tinyEWD.txt";
    	CompetitionFloydWarshall testA = new CompetitionFloydWarshall(A, 60, 70, 90);
    	CompetitionFloydWarshall testB = new CompetitionFloydWarshall(B, 60, 80, 50);
    	CompetitionFloydWarshall testC = new CompetitionFloydWarshall(C, 60, 70, 90);
    	CompetitionFloydWarshall testD = new CompetitionFloydWarshall(D, 50, 80, 60);
    	CompetitionFloydWarshall testF = new CompetitionFloydWarshall(F, 60, 70, 90);
    	CompetitionFloydWarshall testG = new CompetitionFloydWarshall(G, 60, 70, 90);
    	CompetitionFloydWarshall testI = new CompetitionFloydWarshall(I, 72, 70, 65);
    	CompetitionFloydWarshall testJ = new CompetitionFloydWarshall(J, 60, 70, 90);
    	CompetitionFloydWarshall testK = new CompetitionFloydWarshall(K, 60, 70, 90);
    	CompetitionFloydWarshall testL = new CompetitionFloydWarshall(L, 60, 70, 90);
    	CompetitionFloydWarshall testM = new CompetitionFloydWarshall(M, 60, 70, 90);
    	CompetitionFloydWarshall testN = new CompetitionFloydWarshall(N, 60, 70, 90);
    	CompetitionFloydWarshall testTiny = new CompetitionFloydWarshall(tiny, 60, 70, 90);
    	assertEquals("Testing file A with speeds: 60, 70, 90", -1, testA.timeRequiredforCompetition());
    	assertEquals("Testing file B with speeds: 60, 80, 50", 10000, testB.timeRequiredforCompetition());
    	assertEquals("Testing file C with speeds: 60, 70, 90", -1, testC.timeRequiredforCompetition());
    	assertEquals("Testing file D with speeds: 50, 80, 60", 38, testD.timeRequiredforCompetition());
    	assertEquals("Testing file F with speeds: 60, 70, 90", -1, testF.timeRequiredforCompetition());
    	assertEquals("Testing file G with speeds: 60, 70, 90", -1, testG.timeRequiredforCompetition());
    	assertEquals("Testing file I with speeds: 72, 70, 65", 185, testI.timeRequiredforCompetition());
    	assertEquals("Testing file J with speeds: 60, 70, 90", -1, testJ.timeRequiredforCompetition());
    	assertEquals("Testing file K with speeds: 60, 70, 90", 267, testK.timeRequiredforCompetition());
    	assertEquals("Testing file L with speeds: 60, 70, 90", 134, testL.timeRequiredforCompetition());
    	assertEquals("Testing file M with speeds: 60, 70, 90", 250, testM.timeRequiredforCompetition());
    	assertEquals("Testing file N with speeds: 60, 70, 90", 134, testN.timeRequiredforCompetition());
    	assertEquals("Testing file tiny with speeds: 60, 70, 90", 31, testTiny.timeRequiredforCompetition());
    }
}