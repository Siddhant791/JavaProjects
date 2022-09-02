package app.questions;

public class FloodFillProblem {
    static int noOfRows;
    static int noOfColumns;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] image = {{0,0,0},{0,0,0}};
		floodFill(image, 0, 0, 0);
		
	}
	

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) {
        	return image;
        }
    	noOfRows = image.length;
        noOfColumns = image[0].length;
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public static void fill(int[][] image, int sr, int sc, int color,int prev){
        if(sr>-1 && sr<noOfRows && sc>-1 && sc<noOfColumns){
            int current = image[sr][sc];
            if(current==prev){
                image[sr][sc] = color;
                fill(image,sr+1,sc,color,current);
                fill(image,sr-1,sc,color,current);
                fill(image,sr,sc+1,color,current);
                fill(image,sr,sc-1,color,current);
            }
            else{
                return;
            }
        }
        return;
    }

}
