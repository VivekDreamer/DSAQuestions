public class POTD_MergeKSortedLinkedLists {
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int i=0;i<arr.size();i++){
            Node cur = arr.get(i);
            while(cur!=null){
                pq.add(cur.data);
                cur= cur.next;
            }
        }
        Node res = new Node(pq.poll());
        Node curr = res;
        while(!pq.isEmpty()){
            curr.next = new Node(pq.poll());
            curr = curr.next;
        }
        return res;
    }
}
