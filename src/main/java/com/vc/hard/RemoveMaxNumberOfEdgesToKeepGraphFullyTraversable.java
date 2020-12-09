package com.vc.hard;

class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //Edges Needed for Alice & Bob
        int[] parentArrAlice = new int[n + 1];
        int[] parentArrBob = new int[n + 1];
        for(int i = 0; i < parentArrBob.length; i++) {
            parentArrAlice[i] = i;
            parentArrBob[i] = i;
        }

        int toRemove = 0;
        //Process All Type 3 Edges, because both Alice & Bob can use it
        for(int i = 0; i < edges.length; i++) {
            if(edges[i][0] != 3) continue;

            int fromParentAlice = find(edges[i][1], parentArrAlice);
            int toParentAlice = find(edges[i][2], parentArrAlice);

            int fromParentBob = find(edges[i][1], parentArrBob);
            int toParentBob = find(edges[i][2], parentArrAlice);

            if(fromParentAlice == toParentAlice && fromParentBob == toParentBob) {
                toRemove++;
                continue;
            }

            parentArrAlice[fromParentAlice] = toParentAlice;
            parentArrBob[fromParentBob] = toParentBob;
        }

        //Process All Type 2 & 3 Edges
        for(int i = 0; i < edges.length; i++) {
            //Alice's Edge
            if(edges[i][0] == 1) {
                int fromParent = find(edges[i][1], parentArrAlice);
                int toParent = find(edges[i][2], parentArrAlice);

                if(fromParent != toParent) parentArrAlice[fromParent] = parentArrAlice[toParent];
                else toRemove++;
            }
            //Bob's Edge
            else if(edges[i][0] == 2) {
                int fromParent = find(edges[i][1], parentArrBob);
                int toParent = find(edges[i][2], parentArrBob);

                if(fromParent != toParent) parentArrBob[fromParent] = parentArrBob[toParent];
                else toRemove++;
            }
        }

        //Check if Alice & Bob can reach to all the nodes if not return -1;
        return check(parentArrAlice) && check(parentArrBob) ? toRemove : -1;
    }

    private int find(int x, int[] parentArr) {
        if(parentArr[x] == x) return x;
        else return parentArr[x] = find(parentArr[x], parentArr);
    }

    private boolean check(int[] parentArr) {
        int commonParent = find(parentArr[1], parentArr);
        for(int i = 2; i < parentArr.length; i++) {
            int elementParent = find(parentArr[i], parentArr);
            if(elementParent != commonParent) return false;
        }
        return true;
    }
}