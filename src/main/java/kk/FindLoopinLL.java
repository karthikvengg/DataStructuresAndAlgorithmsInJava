package kk;/*
Find loop in Linked list
Reverse a LL (Recursive and non-recursive)
 */

import java.util.*;
/**
 *
 * @author Karthikeyan_Varadara
 */

public class FindLoopinLL{
    NODE1 root;
    
    public static void main(String[] args) {
        FindLoopinLL ls=new FindLoopinLL();
        ls.add(1);
        ls.add(2);
        ls.add(25);
        ls.add(50);
        //ls.root.next.next.next.next=ls.root.next;//Create loop
        //System.out.println(ls.root.next.next.next.next.key);    
        Hashtable<Integer, NODE1> hs=new Hashtable<Integer, NODE1>();
        System.out.println(detectLoopMethod1(ls.root,hs));
        //System.out.println(detectLoopMethod2(ls.root));
        //ls.root = reverseLL(ls.root);
        ls.root = reverseLLRecursion(ls.root,null,ls);
        for(int i=0;i<4;i++)
            System.out.print(ls);
    }
    void add(int key){
        NODE1 n=new NODE1(key);
        if (root==null){
            root=n;
        }
        else{
            NODE1 temp =  root;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
        }
    }
    
    static NODE1 reverseLL(NODE1 head){
        if(head==null)
            return null;
        NODE1 prev=null,temp=null,n;
        n=head;
        while(n!=null){
            temp=n.next;
            n.next=prev;
            prev=n;
            n=temp;
        }  
        return prev;
    }
    
    static NODE1 reverseLLRecursion(NODE1 curr, NODE1 prev, FindLoopinLL ls){
        NODE1 next1;
        if (curr.next==null){
            ls.root=curr;
            curr.next=prev;
            return null;
        }
        next1 = curr.next;
        curr.next=prev;
        reverseLLRecursion(next1,curr,ls);                    
        return ls.root;
    }    
    
    static boolean detectLoopMethod1(NODE1 n, Hashtable<Integer, NODE1> hs){
        if(n==null)
            return false;
        int i = 1;
        while(n.next!=null){
            if(hs.containsValue(n)){
                return true;
            }
            hs.put(i, n);
            i++;
            n=n.next;
        }
        return false;
    }
    
    static boolean detectLoopMethod2(NODE1 n){
        NODE1 p1,p2;
        p1=n;        
        p2=p1;
        while(p1.next!=null){
            p2=p2.next;
            if(p1==p2)
                return true;
            p1=p1.next;
            p2=p2.next;
        }
        return false;        
    }    
}

class NODE1 {
    int key;
    NODE1 next;
    NODE1(int key){
        this.key=key;
    }
}