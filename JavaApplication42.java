/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication42;


import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author phamv
 */
public class JavaApplication42 {

    static int x = 2, y = 2, endx = 4, endy = 4;
    static char[][] map = new char[5][5];
    static Scanner sc = new Scanner(System.in);
    

    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j]='-';
                if(i==x&y==j)
                {
                    map[i][j]='X';
                }
                if(i==endx&j==endy)
                {
                    map[endx][endy]='0';
                }
                
                    
            }
        }
        while(true)
        {
            showmap();
            char inputValue= input();
            move(inputValue);
            moveO();
            
            //System.out.println(kc());
        }
       
    }

    static void showmap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    static char input()
    {
        System.out.println("nhap WASD");
        String inputString = sc.nextLine();
        char inputValue;
        inputValue=inputString.charAt(0);
        return inputValue;
        
        
    }
    static void move(char input)
    {
        switch(input){
            case 'a':
                map[x][y]='-';
                y=(y-1+map.length)%5;
                map[x][y]='X';
                break;
            case 'd':
                map[x][y]='-';
                y=(y+1)%5;
                map[x][y]='X';
                break;
            case 's':
                map[x][y]='-';
                x=(x+1)%5;
                map[x][y]='X';
                break;
            case 'w':
                map[x][y]='-';
                x=(x-1+map.length)%5;
                map[x][y]='X';
                break;    
            
        } 
        
    }
    static void moveO()
    {
     int min= timmin(abs(x-(endx+1)%5)+abs(y-endy),abs(x-(endx+4)%5)+abs(y-endy),
             abs(x-endx)+abs(y-(endy+1)%5),
             abs(x-endx)+abs(y-(endy+4)%5));
     if(min==abs(x-(endx+1)%5)+abs(y-endy))
     {
         map[endx][endy]='-';
         endx=(endx+1)%5;
         map[endx][endy]='O';
               
     }
     if(min==abs(x-(endx+4)%5)+abs(y-endy)){
         map[endx][endy]='-';
         endx=(endx+4)%5;
         map[endx][endy]='O';
         
     }
     if(min==abs(x-endx)+abs(y-(endy+1)%5))
     {
         map[endx][endy]='-';
         endy=(endy+1)%5;
         map[endx][endy]='O';
     }
     if(min==abs(x-endx)+abs(y-(endy+4)%5))
     {
         map[endx][endy]='-';
         endy=(endy+4)%5;
         map[endx][endy]='O';
         
     }
     
     
     
    }
    
    static int timmin(int  a, int b, int c, int d)
    {
        int min=a;
        if(min > b) min=b;
        if(min > c) min=c;
        if(min > d) min=d;
        return min  ;
    }
            

}
