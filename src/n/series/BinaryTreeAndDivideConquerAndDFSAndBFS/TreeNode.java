package n.series.BinaryTreeAndDivideConquerAndDFSAndBFS;

public class TreeNode {
	public int val;
	public TreeNode left,right;
	public TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString(){
		return this.val+"";
	}

}
