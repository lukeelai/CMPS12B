/*Luke Lai	Gabriel Reyes
 * luelai	ghreyes
 * 1355154	1348575
 * 11/17/14
 * Tree.java
 * debugger for xref
 */

import static java.lang.System.*;

class Tree {
  
  private class Node {
    String key;
    Queue<Integer> value;
    Node left;
    Node right;
  }
  private Node root;
  
  private void debugHelper(Node tree, int depth) {
    // Your code here might be recursive
    //print all words in order while keeping track of depth
    //indent=depth*2
    //depth number comes before word (queue not needed)
    if(root==null) 
      System.out.println("Empty Tree");
    if(tree.left!=null)
      debugHelper(tree.left,depth+1);
    for(int i=0; i<depth; i++)
      System.out.print("  ");
    System.out.println(depth + " " +tree.key);
    if(tree.right!=null)
      debugHelper(tree.right,depth+1);
  }
  
  private void outputHelper(Node tree) {
    // Your code here might be recursive
    //Print all words in order with their queues after the item name
    if(root==null) 
      System.out.println("Empty Tree");
    if(tree.left!=null)
      outputHelper(tree.left);
    System.out.print(tree.key+ " ");
    //print all queue values
    tree.value.printAll(tree.value);
    System.out.println();
    if(tree.right!=null)
      outputHelper(tree.right);
  }
  
  public void insert(String key, Integer linenum) {
    // Insert a word into the tree
    if(root==null){
      Node x=new Node();
      root=x;
      x.key=key;
      x.value = new Queue<Integer>();
      x.value.insert(linenum);
    }
    else{
      boolean found=false;
      Node curr=root;
      while(!found){
        if(curr.key.equalsIgnoreCase(key)){
          curr.value.insert(linenum);
          found=true;
        }
        else if(key.compareToIgnoreCase(curr.key)>0){
          if(curr.right!=null)
            curr=curr.right;
          else{
            Node x=new Node();
            curr.right=x;
            x.key=key;
            x.value=new Queue<Integer>();
            x.value.insert(linenum);
            found=true;
          }
        }
        else if(key.compareToIgnoreCase(curr.key)<0){
          if(curr.left!=null)
            curr=curr.left;
          else{
            Node x=new Node();
            curr.left=x;
            x.key=key;
            x.value=new Queue<Integer>();
            x.value.insert(linenum);
            found=true;
          }
        }
      }
    }
  }
  
  public void debug() {
    // Show debug output of tree
    debugHelper(root, 0);
  }
  
  public void output() {
    // Show sorted words with lines where each word appears
    outputHelper(root);
  }
  
}
