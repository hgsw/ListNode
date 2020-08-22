class MyLinkedList {
    private class Node {
        int val;
        Node next;
        public Node (int val,Node next){
            this.val=val;
            this.next=next;
        }
        public Node(int val){this(val,null);}

    }
    /*
         不使用虚拟头结点实现ListNode
     */
    int size;
    Node head;
    public MyLinkedList() {
        size=0;
        head=null;
    }
    public int get(int index) {
        if(index>=size||index<0)
            return -1;
        Node cur=head;
        for(int i=0;i<index;i++)
            cur=cur.next;
        return cur.val;
    }
    public void addAtHead(int val) {
        head=new Node(val,head);
        size++;
    }

    public void addAtTail(int val) {
        if(size==0){
            addAtHead(val);
            return;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        Node newNode=new Node(val);
        cur.next=newNode;
        size++;
    }
    public void addAtIndex(int index, int val) {
        if(index<=0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        if(index>size)
            return;
        Node cur=head;
        for(int i=0;i<index-1;i++)
            cur=cur.next;

        Node newNode=new Node(val);
        newNode.next=cur.next;
        cur.next=newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size)
            return;
        if(index==0)
            head=head.next;
        else{
            Node cur=head;
            for(int i=0;i<index-1;i++){
                cur=cur.next;
            }
            Node delNode=cur.next;
            cur.next=delNode.next;
            delNode=null;
        }
        size--;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Node cur=head;
        while(cur!=null){
            sb.append(cur.val);
            sb.append("->");
            cur=cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
    public static void main(String [] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList);//链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList);
        linkedList.get(1);
    }

}
