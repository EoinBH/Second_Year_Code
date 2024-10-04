import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Eoin Brereton Hurley
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         bst.put(10, 10);	//        ___7___
         bst.put(9, 9);		//      /     	  \
         bst.put(11, 11);	//    _2_     	  _10_
         					//	/     \     /      \
         					// 1	   4   9        11
         					//			\
         					//			 5
         
         
         bst.delete(10);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7(()9(()11())))", bst.printKeysInOrder());
         bst.delete(4);
         assertEquals("Deleting leaf", "(((()1())2(()5()))7(()9(()11())))", bst.printKeysInOrder());
     }
     
     @Test
     public void testHeightandMedian() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("Checking height of empty tree", -1, bst.height());
    	 assertNull("Checking median of empty tree", bst.median());
    	 bst.put(7, 7);   //         7
    	 assertEquals("Checking height of tree with one node", 0, bst.height());
    	 assertEquals("Checking median of tree with one node", bst.select(0), bst.median());
         bst.put(8, 8);   //        _7_
         				  //      /     \
         				  //			 8
         assertEquals("Checking height of non-empty tree", 1, bst.height());
         assertEquals("Checking median of non-empty tree", bst.select(0), bst.median());
         bst.put(3, 3);   //        _7_
		  				  //      /     \
		  				  //	 3	     8
         assertEquals("Checking height of non-empty tree", 1, bst.height());
         assertEquals("Checking median of non-empty tree", bst.select(1), bst.median());
         bst.put(1, 1);	  //        _7_
         bst.put(2, 2);	  //      /     \
         bst.put(6, 6);	  //    _3_      8
         bst.put(4, 4);   //  /     \
         bst.put(5, 5);   // 1       6
            			  //  \     /
            			  //   2   4
            			  //        \
                          //         5
         assertEquals("Checking height of non-empty tree", 4, bst.height());
         assertEquals("Checking median of non-empty tree", bst.select(3), bst.median());
     }
     
     @Test
     public void testPrintKeysInOrder() {
    	 BST<String, String> bst = new BST<String, String>();
    	 assertEquals("Checking print output of empty tree", "()", bst.printKeysInOrder());
         bst.put("G", "G");   //        _G_
         bst.put("H", "H");   //      /     \
         bst.put("C", "C");   //    _C_      H
         bst.put("A", "A");   //  /     \
         bst.put("B", "B");   // A       F
         bst.put("F", "F");   //  \     /
         bst.put("D", "D");   //   B   D
         bst.put("E", "E");   //        \
                          	  //         E
         assertEquals("Checking print output of non-empty tree", "(((()A(()B()))C((()D(()E()))F()))G(()H()))", bst.printKeysInOrder());
     }
     
     @Test
     public void test() {
    	 BST<String, String> bst = new BST<String, String>();
    	 assertFalse("Checking contains() on an empty tree", bst.contains("A"));
         bst.put("G", "G");   //         G
         assertTrue("Checking contains() on a tree with one node", bst.contains("G"));
         bst.put("H", "H");   //        _G_
         bst.put("C", "C");   //      /     \
         					  //     C       H
         assertTrue("Checking contains() on a non-empty tree", bst.contains("C"));
         assertTrue("Checking contains() on a non-empty tree", bst.contains("H"));
         bst.put("C", null);  //        _G_
         					  //            \
		  					  //             H
         assertFalse("Checking contains() on a non-empty tree", bst.contains("C"));
         assertFalse("Checking contains() on a non-empty tree", bst.contains("D"));
         bst.put("X", "X");   //        _G_
         bst.put("Z", "Z");   //      /     \
         bst.put("L", "L");   //    _B_     _H_
         bst.put("B", "B");   //       \        \
         bst.put("F", "F");   //        F       _X_
         bst.put("F", "J");	  //			  /     \
         					  //			 L		 Z
         assertEquals("Checking updated value at a key", "J", bst.get("F"));
         assertNull("", bst.select(-1));
         assertNull("", bst.select(100));
     }
}