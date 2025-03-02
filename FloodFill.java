
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS
/*
class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int m=image.length;
      int n=image[0].length;
      if(image[sr][sc]==color){
          return image;
      }
      Queue<Integer> q=new LinkedList<>();
      q.add(sr);
      q.add(sc);
      int og=image[sr][sc];
      image[sr][sc]=color;
      
      int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
      while(!q.isEmpty()){
          int cr=q.poll();
          int cc=q.poll();
          for(int[] dir:dirs){
              int nr=cr+dir[0];
              int nc=cc+dir[1];
              if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==og){
                  image[nr][nc]=color;
                  q.add(nr);
                  q.add(nc);
              }
          }

      }
      return image;
  }
}
*/
//DFS
/*
Start from the given location, using dfs we move around 4 neighbours. Store the original location color in a variable.
If the neighbor color is same, change to new given color. Same way iterate over their neighbors.
*/
class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int m=image.length;
      int n=image[0].length;
      if(image[sr][sc]==color){
          return image;
      }
      int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
      int og=image[sr][sc];
      
      dfs(image,sr, sc,color,og,dirs);
      return image;
  }

  private void dfs(int[][] image, int sr, int sc, int color, int og, int[][] dirs){
      //base
      if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=og){
          return;
      }

      //logic
      image[sr][sc]=color;
      for(int[] dir:dirs){
          int nr=sr+dir[0];
          int nc=sc+dir[1];
          dfs(image,nr,nc,color,og,dirs);
      }
  }
}