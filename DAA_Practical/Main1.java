package DAA_Practical;

import java.util.*;
public class Main1
{
    static class MinHeapNode{
        int freq;
        char data;
        MinHeapNode left,right;
        
        MinHeapNode(char data,int freq){
            this.data = data;
            this.freq = freq;
        }
    }
    
    static void printCode(MinHeapNode root,String str){
        if(root == null){
            return;
        }
        
        if(root.data !='$'){
            System.out.println(root.data + ":" + str );
        }
        
        printCode(root.left,str+"0");
        printCode(root.right,str+"1");
    }
    
    static class Compare implements Comparator<MinHeapNode>{
        public int compare(MinHeapNode a,MinHeapNode b){
            return a.freq-b.freq;
        }
    }
    static void buildHuffmanTree(char[]data,int freq[],int size){
        int n = data.length;
        MinHeapNode left,right,temp;
        PriorityQueue<MinHeapNode>minHeap=new PriorityQueue<>(new Compare());
        for(int i=0;i<size;i++){
            minHeap.add(new MinHeapNode(data[i],freq[i]));
        }
        
        while(minHeap.size()>1){
            left =minHeap.poll();
            right = minHeap.poll();
            temp = new MinHeapNode('$',left.freq+right.freq);
            temp.left=left;
            temp.right=right;
            minHeap.add(temp);
        }
        printCode(minHeap.peek(),"");
    }
    
	public static void main(String[] args) {
	char []data={'A', 'B', 'C', 'D','E','F'};
	int freq[]={5,9,12,13,16,45};
	buildHuffmanTree(data,freq,6);
	}
}

