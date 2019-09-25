package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.List;

import com.mycompany.utils.Node;

import org.junit.Test;

/**
 * Unit test for LowestCommonAncestor.
 * TODO create a script to run the tests
 */
public class LowestCommonAncestorTest {

    @Test
    public void givenEmptyTreeShouldReturnNull() {
        Node result = LowestCommonAncestor.getLowestCommonAncestor(null, null);
        assertNull(result);
    }

    @Test
    public void givenEmptyFirstNodeToFindAncestorOfShouldReturnNull() {
        Node root = new Node(5);
        List<Node> descendants = new LinkedList<>();
        Node result = LowestCommonAncestor.getLowestCommonAncestor(root, descendants);
        assertNull(result);
    }

    @Test
    public void givenEmptySecondNodeToFindAncestorOfShouldReturnNull() {
        Node root = new Node(5);
        List<Node> descendants = new LinkedList<>();
        Node result = LowestCommonAncestor.getLowestCommonAncestor(root, descendants);
        assertNull(result);
    }

    @Test
    public void givenTreeWithRootAndTwoChildrenAsDescendantsShouldReturnRootAsAncestorOfChildren() {
        // Make the tree
        Node root = new Node(5);
        Node child1 = new Node(4);
        Node child2 = new Node(8);
        root.addChild(child1);
        root.addChild(child2);

        List<Node> descendants = new LinkedList<>();
        descendants.add(child1);
        descendants.add(child2); 

        // Get the common ancestor
        Node result = LowestCommonAncestor.getLowestCommonAncestor(root, descendants);
        System.out.println("DATA " + result.getData()); // TODO delete this
        assertEquals(root, result);
    }

   // public void givenTreeWithRootAndThreeChildrenAsDescendantsShouldReturnRootAsAncestorOfChildren()
   // ^^^^ does this test anything that above doesn't test? TODO 
   
   // TODO linear example on slides doesn't match wikipedia --> can a node
    // TODO be an ancestor of itself for this class?
    // @Test
    // public void givenTreeWithRootInDecendantsShouldReturnRoot() {
    //     // Make the tree
    //     Node root = new Node(5);
    //     Node leftNode = new Node(2);
    //     root.setLeft(leftNode);

    //     // Get the common ancestor
    //     Node result = LowestCommonAncestor.getLowestCommonAncestor(root, root, leftNode);
    //     assertEquals(root, result);
    // }

    // @Test
    // public void givenTreeWithRootAsSecondNodeToFindAncestorOfShouldReturnRoot() {
    //     // Make the tree
    //     Node root = new Node(5);
    //     Node leftNode = new Node(2);
    //     root.setLeft(leftNode);

    //     // Get the common ancestor
    //     Node result = LowestCommonAncestor.getLowestCommonAncestor(root, leftNode, root);
    //     assertEquals(root, result);
    // }

    // TODO linear wikipedia doesn't match slides --> which to follow?
    // @Test
    // public void givenLinearTreeAndNonRootNodesToFindNonRootAncestorOfShouldReturnCorrectNode() {
    //     // Make the tree
    //     Node root = new Node(500);
    //     Node leftNode1 = new Node(200);
    //     root.setLeft(leftNode1);
    //     Node leftNode2 = new Node(40);
    //     leftNode1.setLeft(leftNode2);
    //     Node leftNode3 = new Node(10);
    //     leftNode2.setLeft(leftNode3);
    //     Node leftNode4 = new Node(5);
    //     leftNode3.setLeft(leftNode4);
    //     Node leftNode5 = new Node(0);
    //     leftNode4.setLeft(leftNode5);

    //     Node result = LowestCommonAncestor.getLowestCommonAncestor(root, leftNode5, leftNode2);
    //     // System.out.println("result: " + (result.getData()));
    //     // TODO what is the correct output when the node is in a line?
    //     // TODO the class slides suggest that it can't be the a node looking for
    //     // decendants itself,
    //     // TODO but the online description says that it can be
    //     // TODO "The lowest common ancestor between two nodes n1 and n2 is defined as
    //     // the lowest node in T that has both n1 and n2 as descendants (where we allow a
    //     // node to be a descendant of itself)"
    //     // TODO from
    //     // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    //     // assertEquals(leftNode1, result);
    //     assertEquals(leftNode2, result); // based on online def
    // }

     @Test
     public void givenTreeWithTwoSubtreesAndNodesInOneSubtreeShouldReturnThatSubtreeRootAsAncestor() {
        Node root = new Node(15);
        Node firstSubtreeRoot = new Node(10);
        Node secondSubtreeRoot = new Node(25);
        root.addChild(firstSubtreeRoot);
        root.addChild(secondSubtreeRoot);

        Node firstSubtreeFirstChild = new Node(12);
        Node firstSubtreeSecondChild = new Node(13);
        Node firstSubtreeThirdChild = new Node(14);
        firstSubtreeRoot.addChild(firstSubtreeFirstChild);
        firstSubtreeRoot.addChild(firstSubtreeSecondChild);
        firstSubtreeRoot.addChild(firstSubtreeThirdChild);

        Node secondSubtreeFirstChild = new Node(12);
        Node secondSubtreeSecondChild = new Node(13);
        Node secondSubtreeThirdChild = new Node(14);
        secondSubtreeRoot.addChild(secondSubtreeFirstChild);
        secondSubtreeRoot.addChild(secondSubtreeSecondChild);
        secondSubtreeRoot.addChild(secondSubtreeThirdChild);

        List<Node> descendants = new LinkedList<>();
        descendants.add(firstSubtreeFirstChild);
        descendants.add(firstSubtreeThirdChild);

        Node result = LowestCommonAncestor.getLowestCommonAncestor(root, descendants);
        assertEquals(firstSubtreeRoot, result);
     }

    // @Test
    // public void givenBinaryTreeWithTwoSubtreesAndNodesInLeftSubtreeShouldReturnLeftSubtreeRootAsAncestor() {
    //     // Make the tree - root
    //     Node root = new Node(15);
    //     Node leftSubtreeRoot = new Node(10);
    //     root.setLeft(leftSubtreeRoot);
    //     Node rightSubtreeRoot = new Node(25);
    //     root.setRight(rightSubtreeRoot);

    //     // Make the tree - left subtree
    //     Node leftSubtreeLeftChild = new Node(8);
    //     leftSubtreeRoot.setLeft(leftSubtreeLeftChild);
    //     Node leftSubtreeRightChild = new Node(12);
    //     leftSubtreeRoot.setRight(leftSubtreeRightChild);

    //     // Make the tree - right subtree
    //     Node rightSubtreeLeftChild = new Node(20);
    //     rightSubtreeRoot.setLeft(rightSubtreeLeftChild);
    //     Node rightSubtreeRightChild = new Node(30);
    //     rightSubtreeRoot.setRight(rightSubtreeRightChild);

    //     Node result = LowestCommonAncestor.getLowestCommonAncestor(root, leftSubtreeLeftChild, leftSubtreeRightChild);
    //     assertEquals(leftSubtreeRoot, result);
    // }

    // @Test
    // public void givenBinaryTreeWithTwoSubtreesAndNodesInDifferentSubtreeShouldReturnRootAsAncestor() {
    //     // Make the tree - root
    //     Node root = new Node(15);
    //     Node leftSubtreeRoot = new Node(10);
    //     root.setLeft(leftSubtreeRoot);
    //     Node rightSubtreeRoot = new Node(25);
    //     root.setRight(rightSubtreeRoot);

    //     // Make the tree - left subtree
    //     Node leftSubtreeLeftChild = new Node(8);
    //     leftSubtreeRoot.setLeft(leftSubtreeLeftChild);
    //     Node leftSubtreeRightChild = new Node(12);
    //     leftSubtreeRoot.setRight(leftSubtreeRightChild);

    //     // Make the tree - right subtree
    //     Node rightSubtreeLeftChild = new Node(20);
    //     rightSubtreeRoot.setLeft(rightSubtreeLeftChild);
    //     Node rightSubtreeRightChild = new Node(30);
    //     rightSubtreeRoot.setRight(rightSubtreeRightChild);

    //     Node result = LowestCommonAncestor.getLowestCommonAncestor(root, rightSubtreeLeftChild, leftSubtreeLeftChild);
    //     assertEquals(root, result);
    // }

    // TODO test --> what happens if given a node that isn't in the tree/isn't
    // attached to the root
    // TODO and can't be found?
}
