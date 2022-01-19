#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <stdbool.h>

#define width 8
#define height 8

enum{
    color_white=0,color_brack=1,color_no=2,color_MAX
};
enum{
    direction_up,
    direction_upleft,
    direction_uplight,
    direction_left,
    direction_downleft,
    direction_downlight,
    direction_down,
    direction_light,
    direction_MAX
};
int directions[][2]={
    {0,-1},//direction_up,
    {-1,-1},//direction_upleft,
    {1,-1},//direction_uplight,
    {-1,0},//direction_left,
    {-1,1},//direction_downleft,
    {1,1},//direction_downlight,
    {0,1},//direction_down,
    {1,0},//direction_light,
};

char name[][6] = {
    "white",
    "brack"
};

int masu[height][width];

int cursorX,cursorY;

int turn;

bool check(int _color,int _x,int _y,bool _turn){
    if(masu[_y][_x] !=color_no)
    return false;
    for(int i=0;i<direction_MAX;i++){
        int x=_x,y=_y;
        x+=directions[i][0];
        y+=directions[i][1];
        if(masu[y][x]!=(_color^1))
        continue;
        while(1){
            x+=directions[i][0];
            y+=directions[i][1];

            if((x<0) || x>width || (y<0) || y>height)
            break;
            if(masu[y][x]==color_no)
            break;
            if(masu[y][x]==_color){
                if(!_turn)
            return true;
            int x2 = _x,y2 = _y;
            while(1){
                masu[y2][x2] = _color;
                x2+=directions[i][0];
                y2+=directions[i][1];
                if((x2 == x) && (y2 == y))
                break;
            }
            }
        }
    }
    return false;
}

bool checkpass(int _color){
    int x,y;
    for(y=0;y<height;y++)
    for(x=0;x<width;x++)
    if (check(_color,x,y,false))
    return true;

return false;
}

void bord(){
   system("cls");
        for(int y=0;y<height;y++){
        for(int x=0;x<width;x++)
        if((x==cursorX) && (y==cursorY))
        printf("+");
        else{
            switch(masu[y][x]){
               case color_brack:printf("◎");break;
               case color_white:printf("〇");break;
               case color_no:printf("・");break; 
            }
        }
            printf("\n");
            } 
}

int main(){
    int x,y;
    bool cant = false;
    for(y=0;y<height;y++)
        for(x=0;x<width;x++)
        masu[y][x]=color_no;
        masu[3][3]=color_white;
        masu[4][4]=color_white;
        masu[4][3]=color_brack;
        masu[3][4]=color_brack;
    while(1){
        bord();
            if(cant)
            printf("そこは置けません!\n");
            else{
        printf("%sターン\n",name[turn]);}
        cant = false;
    switch(_getch()){
        case 'w':   cursorY--;break;
        case 'a':   cursorX--;break;
        case 's':   cursorY++;break; 
        case 'd':   cursorX++;break;
        case 'p':   turn ^=1;printf("パス\n");break;
        case 'g':   
        if(!check(turn,cursorX,cursorY,false)){
            cant = true;
            break;
        }
        check(turn,cursorX,cursorY,true);

        masu[cursorY][cursorX] = turn;
        turn ^=1;

        if(!checkpass(true))
        turn ^=1;
        break;
    }
    if((!checkpass(color_brack)) && (!checkpass(color_white))){
        
        int count[color_MAX] = {};
        for(y=0;y<height;y++)
        for(x=0;x<width;x++)
        if(masu[y][x]!=color_no)
        count[masu[y][x]]++;
        bord();
        for(int i=0;i<color_MAX;i++)
        printf("%s:%d\n",name[i],count[i]);
        
        if(count[color_brack] == count[color_white])
            printf("draw\n");
        
        if(count[color_brack] > count[color_white])
            printf("brackの勝利\n");

        if(count[color_brack] > count[color_white])
            printf("whiteの勝利\n");


        printf("ゲーム終了です\n");
        break;
    }
    }
}