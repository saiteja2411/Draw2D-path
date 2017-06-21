
package draw2dpath;

public class Draw2DPath {

   
    public static void main(String[] args) {
        
        // 2 - DOWN , 4 - LEFT , 6 - RIGHT , 8 - UP
        int cD=0, cL=0,cR=0,cU=0;
        int arr[] = {6,6,6,6,2,2,2,2,2,2,4,4,4,4,8,8,8,4,4,4,4,4,4,2,2,2,2};
        //int arr[]={6,6,6,6,6,6,8,8,8,8,4,4,4,2,2,2,2,2,2,2,2};
        for(int i=0;i<arr.length;i++){
            switch (arr[i]){
                case 2:cD++;break;
                case 4:cL++;break;
                case 6:cR++;break;
                case 8:cU++;break;
                default : System.out.println("not a good array");break;
            }
        }
        int max=cD;
        if(cL>max)
            max=cL;
        if(cR>max)
            max=cR;
        if(cU>max)
            max=cR;
        
        int l=max*2, r=max*2;
        int row,col;
        Character graph[][]= new Character[l][r];
        
        row=max;
        col=max;
        
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){
                graph[i][j]=' ';
            }
            //System.out.println("");
        }
        
        //System.out.println(row);
        graph[row][col]='X';
        for(int i=0;i<arr.length;i++){
            
            if(i+1<arr.length){
                if(arr[i]==6 && arr[i+1]==6 ){
                    graph[row][++col]='-';
                }
                else if(arr[i]==6 && arr[i+1]!=6 ){
                    if(arr[i+1]==2)
                        graph[row][++col]='\\';
                    if(arr[i+1]==8)
                        graph[row][++col]='/';
                }
                
                if(arr[i]==8 && arr[i+1]==8){
                    graph[--row][col]='|';
                }
                else if(arr[i]==8 && arr[i+1]!=8 ){
                    if(arr[i+1]==4)
                        graph[--row][col]='\\';
                    if(arr[i+1]==6)
                        graph[--row][++col]='/';
                }
                
                if(arr[i]==4 && arr[i+1]==4 ){
                    graph[row][--col]='-';
                }
                else if(arr[i]==4 && arr[i+1]!=4 ){
                    if(arr[i+1]==8)
                        graph[row][--col]='\\';
                    if(arr[i+1]==2)
                        graph[row][--col]='/';
                }
                
                if(arr[i]==2 && arr[i+1]==2 ){
                    if(graph[1+row][col]!=' ')
                        graph[++row][col]='+';
                    else
                        graph[++row][col]='|';
                }
                else if(arr[i]==2 && arr[i+1]!=2 ){
                     if(arr[i+1]==6)
                        graph[++row][col]='\\';
                    
                    if(arr[i+1]==4 && graph[1+row][col]!=' ')
                        graph[++row][col]='+';
                    else if(arr[i+1]==4)
                        graph[++row][col]='/';
                }
            }
        }
        
        
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++)
                System.out.print(graph[i][j]);
            System.out.println("");
        }
    }
    
}
