import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
                
            }
        }
        /*
        int dist=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc]=dist;
                    }
                }
                
            }
            dist++;
        }
        return mat;
        */
       
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc]=mat[curr[0]][curr[1]]+1;
                    }
                }
                
            }
        }
        return mat;
    }
}
/*
class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    mat[i][j]=dfs(mat,dp,i,j);
                }
            }
        }
        return mat;
    }

    private int dfs(int[][] mat, int[][] dp,int r, int c){
        //base
        if(r<mat.length-1  && mat[r+1][c]==0 ){
            dp[r][c]=1;
            return 1;
        }
        if(r-1>=0  && mat[r-1][c]==0 ){
            dp[r][c]=1;
            return 1;
        }
        if(c<mat[0].length-1  && mat[r][c+1]==0 ){
            dp[r][c]=1;
            return 1;
        }
        if(c-1>=0  && mat[r][c-1]==0 ){
            dp[r][c]=1;
            return 1;
        }
        //logic
        int top= 99999;
        if(r>0 && dp[r-1][c]!=0){

            top=dp[r-1][c];
        }
        int left= 99999;
        if(c>0 && dp[r][c-1]!=0){
            left=dp[r][c-1];
        }
        
        int bot=99999;
        if(r+1<mat.length){
            if(dp[r+1][c]==0){
                dp[r+1][c]=dfs(mat,dp,r+1,c);
            }
            bot= dp[r+1][c];
        }
        int right=99999;
        if(c+1<mat[0].length){
            if(dp[r][c+1]==0){
                dp[r][c+1]=dfs(mat,dp,r,c+1);
            }
            right= dp[r][c+1];
        }
        int re=Math.min(right,Math.min(top,Math.min(left,bot)))+1;
        dp[r][c]=re;
        return dp[r][c];
    }
}*/
