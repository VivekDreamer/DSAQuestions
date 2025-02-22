class GFG_FloorInBST {
    public static int floor(Node root, int x) {
        if(root == null) return -1;
        int floor = -1;
        while(root != null){
            if(root.data == x){
                floor = root.data;
                return floor;
            }
            if(root.data > x){
                root = root.left;
            }else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
