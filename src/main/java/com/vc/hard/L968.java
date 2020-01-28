package com.vc.hard;

class L968 {
    final private int MONITORED_WITH_CAM = 1, MONITORED_WITHOUT_CAM = 2, NOT_MONITORED = 0;
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        int status = solve(root);
        cameras += status == NOT_MONITORED ? 1 : 0;
        return cameras;
    }

    private int solve(TreeNode root) {
        if(root == null) return MONITORED_WITHOUT_CAM;
        int left = solve(root.left);
        int right = solve(root.right);
        if(left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITH_CAM;
        }
        else if(left == MONITORED_WITHOUT_CAM && right == MONITORED_WITHOUT_CAM) {
            return NOT_MONITORED;
        }
        else return MONITORED_WITHOUT_CAM;
    }
}