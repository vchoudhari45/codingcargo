package com.vc.medium;

class L1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parentCount = new int[n];
        int[] parentArr = new int[n];

        for(int i = 0; i < parentArr.length; i++) parentArr[i] = i;

        //Every node should have 1 parent and root node should have zero parent
        for(int i = 0; i < leftChild.length; i++) {
            if(leftChild[i] != -1) {
                parentCount[leftChild[i]]++;

                int fromParent = find(i, parentArr);
                int toParent = find(leftChild[i], parentArr);

                parentArr[toParent] = fromParent;
            }
            if(rightChild[i] != -1) {
                parentCount[rightChild[i]]++;

                int fromParent = find(i, parentArr);
                int toParent = find(rightChild[i], parentArr);

                parentArr[toParent] = fromParent;
            }
        }

        boolean rootFound = false;
        for(int i = 0; i < parentCount.length; i++) {
            //System.out.print(parentCount[i]+" ");
            if(parentCount[i] == 0) {
                if(rootFound) return false;
                else rootFound = true;
            }
            if(parentCount[i] > 1) return false;
        }

        /**
             There should be only one parent for all the nodes
             4
             [1,2,0,-1]
             [-1,-1,-1,-1]
         */
        int parent = find(0, parentArr);
        for(int i = 1; i < parentArr.length; i++) {
            if(parent != find(i, parentArr)) return false;
        }

        return rootFound;
    }

    private int find(int x, int[] parentArr) {
        if(x == parentArr[x]) return x;
        else return parentArr[x] = find(parentArr[x], parentArr);
    }
}
