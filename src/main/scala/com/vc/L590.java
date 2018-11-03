package com.vc;

import java.util.ArrayList;
import java.util.List;

class L590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node root, List<Integer> list){
        if(root != null) {
            for(Node node : root.children) {
                postOrder(node, list);
            }
            list.add(root.val);
        }
    }
}
