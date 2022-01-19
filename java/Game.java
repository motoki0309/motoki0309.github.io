import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.Random;


public class Game{
public static Frame Frame;
public static boolean loop;
public static void main(String[] args) {
    Frame = new Frame();
    loop = true;

    int i=1;
    int count=0;
    int ulta=0;
    int ultb=0;
    int turn=0;
    int turnb=0;

    Graphics gra = Frame.panel.image.getGraphics();
    
    long startTime;
        long fpsTime = 0;
        int fps = 30;
        int FPS = 0;
        int FPSCount = 0;

    Enue screen = Enue.START;

    int playerX = 0, playerY = 0;
    int playerx = 0, playery = 0;
    int playerA = 0, playerB = 0;
    int playera = 0, playerb = 0;
    int player=0;
    
     int bombx = 0, bomby = 0;
    //int bulletInterval = 0;
         ArrayList<Bullet> bullets_player = new ArrayList<>();
         ArrayList<Bullet> bullets_enemy = new ArrayList<>();
         ArrayList<Enemy> enemies = new ArrayList<>();
         Random random = new Random();

    while(loop){

        if((System.currentTimeMillis() - fpsTime) >= 1000) {
            fpsTime = System.currentTimeMillis();
            FPS = FPSCount;
            FPSCount = 0;
        }
        FPSCount++;
        startTime = System.currentTimeMillis();

        gra.setColor(Color.WHITE);
        gra.fillRect(0,0,500,500);
       
        switch(screen){
            case START:
            gra.setColor(Color.BLACK);
            Font font = new Font("SansSerif", Font.PLAIN, 50);
            gra.setFont(font);
            FontMetrics metrics = gra.getFontMetrics(font);
            gra.drawString("S&D", 250 - (metrics.stringWidth("Game") / 2), 100);
            font = new Font("SansSerif", Font.PLAIN, 20);
            gra.setFont(font);
            metrics = gra.getFontMetrics(font);
            gra.drawString("Press SPACE to Start", 250 - (metrics.stringWidth("Press SPACE to Start") / 2), 160);
            if(Keybord.isKeyPressed(KeyEvent.VK_SPACE)) {
                screen = Enue.GAME;
                bullets_player = new ArrayList<>();
                bullets_enemy = new ArrayList<>();
                enemies = new ArrayList<>();
                playerX = 235;
                playerY = 400;
                playerx = 235;
                playery = 100;
                playerA = 285;
                playerB = 400;
                playera = 285;
                playerb = 100;

                bombx = 235;
                bomby = 250;
                ulta=0;
                ultb=0;
                turn=0;
                turnb=0;
            }
            break;
            case GAME:
            gra.setColor(Color.BLACK);
            Font newfont = new Font("SansSerif", Font.PLAIN, 180);
            gra.setFont(newfont);
            FontMetrics newmetrics = gra.getFontMetrics(newfont);
            gra.drawString("_______________________________________________________________", 300 - (newmetrics.stringWidth("_______________________________________________________________") / 2), 225);
            if(count==1){  
            gra.setColor(Color.YELLOW);
            Font new1font = new Font("SansSerif", Font.PLAIN, 180);
            gra.setFont(new1font);
            FontMetrics new1metrics = gra.getFontMetrics(new1font);
            gra.drawString("_______________________________________________________________", 300 - (new1metrics.stringWidth("_______________________________________________________________") / 2), 225); 
            }
            if(turn==0&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("1ターン", 300 - (new1metrics.stringWidth("1ターン") / 2), 50); }
            if(turn==1&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("2ターン", 300 - (new1metrics.stringWidth("2ターン") / 2), 50); }
            if(turn==2&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("3ターン", 300 - (new1metrics.stringWidth("3ターン") / 2), 50); }
            if(turn==3&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("4ターン", 300 - (new1metrics.stringWidth("4ターン") / 2), 50); }
            if(turn==4&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("5ターン", 300 - (new1metrics.stringWidth("5ターン") / 2), 50); }
            if(turn==5&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("6ターン", 300 - (new1metrics.stringWidth("6ターン") / 2), 50); }
            if(turn==6&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("7ターン", 300 - (new1metrics.stringWidth("7ターン") / 2), 50); }
            if(turn==7&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("8ターン", 300 - (new1metrics.stringWidth("8ターン") / 2), 50); }
            if(turn==8&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("9ターン", 300 - (new1metrics.stringWidth("9ターン") / 2), 50); }
            if(turn==9&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("10ターン", 300 - (new1metrics.stringWidth("10ターン") / 2), 50); }
            if(turn==10&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("11ターン", 300 - (new1metrics.stringWidth("11ターン") / 2), 50); }
            if(turn==11&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("12ターン", 300 - (new1metrics.stringWidth("12ターン") / 2), 50); }
            if(turn==12&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("13ターン", 300 - (new1metrics.stringWidth("13ターン") / 2), 50); }
            if(turn==13&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("14ターン", 300 - (new1metrics.stringWidth("14ターン") / 2), 50); }
            if(turn==14&&turnb<20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("15ターン", 300 - (new1metrics.stringWidth("15ターン") / 2), 50); }
            if(i==1){  gra.setColor(Color.RED);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("防衛ターン", 200 - (new1metrics.stringWidth("防衛ターン") / 2), 50); }
            if(i==0){  gra.setColor(Color.BLUE);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("攻撃ターン", 200 - (new1metrics.stringWidth("攻撃ターン") / 2), 50); }
            if(turnb==20){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("あと4ターン", 300 - (new1metrics.stringWidth("あと5ターン") / 2), 50); }
            if(turnb==21){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("あと3ターン", 300 - (new1metrics.stringWidth("あと4ターン") / 2), 50); }
            if(turnb==22){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("あと2ターン", 300 - (new1metrics.stringWidth("あと3ターン") / 2), 50); }
            if(turnb==23){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("あと1ターン", 300 - (new1metrics.stringWidth("あと2ターン") / 2), 50); }
            if(turnb==24){  gra.setColor(Color.BLACK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("あと1ターン", 300 - (new1metrics.stringWidth("あと1ターン") / 2), 50); }

            if(player==1&&i==1){  gra.setColor(Color.RED);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("play red", 300 - (new1metrics.stringWidth("play red") / 2), 20); }
            if(player==1&&i==0){  gra.setColor(Color.BLUE);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("play blue", 300 - (new1metrics.stringWidth("play blue") / 2), 20); }
            if(player==2&&i==1){  gra.setColor(Color.PINK);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("paly pink", 300 - (new1metrics.stringWidth("play pink") / 2), 20); }
            if(player==2&&i==0){  gra.setColor(Color.GREEN);Font new1font = new Font("SansSerif", Font.PLAIN, 18);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("play green", 300 - (new1metrics.stringWidth("play green") / 2), 20); }

            gra.setColor(Color.RED);Font new1font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new1font);FontMetrics new1metrics = gra.getFontMetrics(new1font);gra.drawString("[w:↑][a:←][s:↓][d:→]", 55 - (new1metrics.stringWidth("[w:↑][a:←][s:↓][d:→]") / 2), 30);
            gra.setColor(Color.RED);Font new2font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new2font);FontMetrics new2metrics = gra.getFontMetrics(new2font);gra.drawString("only onetimes[q:2*↓]", 55 - (new2metrics.stringWidth("only onetimes[q:2*↓]") / 2), 45);
            gra.setColor(Color.BLUE);Font new3font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new3font);FontMetrics new3metrics = gra.getFontMetrics(new3font);gra.drawString("[↑][←][↓][→]kill:k", 55 - (new3metrics.stringWidth("[↑][←][↓][→]") / 2), 300);
            gra.setColor(Color.BLUE);Font new4font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new4font);FontMetrics new4metrics = gra.getFontMetrics(new4font);gra.drawString("only onetimes[p:2*↑]", 55 - (new4metrics.stringWidth("only onetimes[p:2*↑]") / 2), 315);
            gra.setColor(Color.RED);Font new5font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new5font);FontMetrics new5metrics = gra.getFontMetrics(new5font);gra.drawString("destroy:x", 55 - (new5metrics.stringWidth("destroy:x") / 2), 60);
            gra.setColor(Color.BLUE);Font new6font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new5font);FontMetrics new6metrics = gra.getFontMetrics(new6font);gra.drawString("search:g", 55 - (new6metrics.stringWidth("search:g") / 2), 330);
            gra.setColor(Color.BLUE);Font new7font = new Font("SansSerif", Font.PLAIN, 11);gra.setFont(new7font);FontMetrics new7metrics = gra.getFontMetrics(new7font);gra.drawString("color change:1||2", 55 - (new7metrics.stringWidth("color change:1||2") / 2), 345);

            gra.setColor(Color.BLUE);
            gra.fillRect(playerX + 10, playerY, 10, 10);
            gra.fillRect(playerX, playerY + 10, -30, 10);
            gra.setColor(Color.RED);
            gra.fillRect(playerx + 10, playery, 10, 10);
            gra.fillRect(playerx, playery + 10, -30, 10);
            gra.setColor(Color.GREEN);
            gra.fillRect(playerA + 10, playerB, 10, 10);
            gra.fillRect(playerA, playerB + 10, -30, 10);
            gra.setColor(Color.PINK);
            gra.fillRect(playera + 10, playerb, 10, 10);
            gra.fillRect(playera, playerb + 10, -30, 10);

                    if(Keybord.isKeyPressed(KeyEvent.VK_1)&&i==0){player=1;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_2)&&i==0){player=2;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_1)&&i==1){player=1;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_2)&&i==1){player=2;}
            

                    if(Keybord.isKeyPressed(KeyEvent.VK_LEFT)&&playerX>50&&i==0&&player==1) {i++;turn++;playerX-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_RIGHT)&&playerX<400&&i==0&&player==1) {i++;turn++;playerX+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_UP)&&playerY>30&&i==0&&player==1) {i++;turn++;playerY-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_P)&&playerY>30&&i==0&&ulta==0&&player==1) {i++;turn++;playerY-=100;ulta++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_DOWN)&&playerY<450&&i==0&&player==1) {i++;turn++;playerY+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_G)&&playerY==250&&i==0&&count==0&&player==1) {i++;turn=0;turnb=20;count++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_K)&&player==1&&((playery==playerY&&playerx==playerX)||(playerb==playerB&&playera==playerA)||(playery==playerB&&playerx==playerA))&&i==0){screen = Enue.GAMEOVER2;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_K)&&player==2&&((playery==playerY&&playerx==playerX)||(playerb==playerB&&playera==playerA)||(playery==playerB&&playerx==playerA))&&i==0){screen = Enue.GAMEOVER2;}

                    if(Keybord.isKeyPressed(KeyEvent.VK_LEFT)&&playerA>50&&i==0&&player==2) {i++;turn++;playerA-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_RIGHT)&&playerA<400&&i==0&&player==2) {i++;turn++;playerA+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_UP)&&playerB>30&&i==0&&player==2) {i++;turn++;playerB-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_P)&&playerB>30&&i==0&&ulta==0&&player==2) {i++;turn++;playerB-=100;ulta++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_DOWN)&&playerB<450&&i==0&&player==2) {i++;turn++;playerB+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_G)&&playerB==250&&i==0&&count==0&&player==2) {i++;turn=0;turnb=20;count++;}
                        
                    // if(Keybord.isKeyPressed(KeyEvent.VK_K)&&player==1&&((playery==playerY&&playerx==playerX)||(playerb==playerB&&playera==playerA)||(playery==playerB&&playerx==playerA))&&i==1){screen = Enue.GAMEOVER;}
                    // if(Keybord.isKeyPressed(KeyEvent.VK_K)&&player==2&&((playery==playerY&&playerx==playerX)||(playerb==playerB&&playera==playerA)||(playery==playerB&&playerx==playerA))&&i==1){screen = Enue.GAMEOVER;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_A)&&playerx>50&&i==1&&player==1) {i--;turnb++;playerx-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_D)&&playerx<400&&i==1&&player==1) {i--;turnb++;playerx+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_W)&&playery>30&&i==1&&player==1) {i--;turnb++;playery-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_Q)&&count==0&&playery<450&&playery<150&&i==1&&ultb==0&&player==1) {i--;turnb++;playery+=100;ultb++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_S)&&count==0&&playery<450&&playery<200&&i==1&&player==1) {i--;turnb++;playery+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_Q)&&(count==1||playerY==250||playerB==250)&&playery<450&&i==1&&ultb==0&&player==1) {i--;turnb++;playery+=100;ultb++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_S)&&(count==1||playerY==250||playerB==250)&&playery<450&&i==1&&player==1) {i--;turnb++;playery+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_X)&&playery==250&&i==1&&count==1&&player==1) {count++;}

                    if(Keybord.isKeyPressed(KeyEvent.VK_A)&&playera>50&&i==1&&player==2) {i--;turnb++;playera-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_D)&&playera<400&&i==1&&player==2) {i--;turnb++;playera+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_W)&&playerb>30&&i==1&&player==2) {i--;turnb++;playerb-=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_Q)&&count==0&&playerb<450&&playerb<150&&i==1&&ultb==0&&player==2) {i--;turnb++;playerb+=100;ultb++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_S)&&count==0&&playerb<450&&playerb<200&&i==1&&player==2) {i--;turnb++;playerb+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_Q)&&(count==1||playerY==250||playerB==250)&&playerb<450&&i==1&&ultb==0&&player==2) {i--;turnb++;playerb+=100;ultb++;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_S)&&(count==1||playerY==250||playerB==250)&&playerb<450&&i==1&&player==2) {i--;turnb++;playerb+=50;}
                    if(Keybord.isKeyPressed(KeyEvent.VK_X)&&playerb==250&&i==1&&count==1&&player==2) {count++;}

                    

                    if(turn==15){screen = Enue.GAMEOVER;}
                    if(turnb==24){screen = Enue.GAMEOVER2;}
                        
                    if(count==2){
                        screen = Enue.GAMEOVER;
                    }
        
            break;
             case GAMEOVER:
             gra.setColor(Color.RED);
            Font nenfont = new Font("SansSerif", Font.PLAIN, 20);
            gra.setFont(nenfont);
            FontMetrics newnmetrics = gra.getFontMetrics(nenfont);
            gra.drawString("防衛側の勝ちです", 300 - (newnmetrics.stringWidth("カウンターテロリストの勝ちです") / 2), 150);
            gra.drawString("再ゲームはspace", 300 - (newnmetrics.stringWidth("再ゲームはspace") / 2), 225); 
            count=0;
            if(Keybord.isKeyPressed(KeyEvent.VK_SPACE)) screen = Enue.START;
            break;

            case GAMEOVER2:
            gra.setColor(Color.BLUE);
            Font nefont = new Font("SansSerif", Font.PLAIN, 20);
            gra.setFont(nefont);
            FontMetrics nenmetrics = gra.getFontMetrics(nefont);
            gra.drawString("攻撃側の勝ちです", 300 - (nenmetrics.stringWidth("テロリストの勝ちです") / 2), 150);
            gra.drawString("再ゲームはspace", 300 - (nenmetrics.stringWidth("再ゲームはspace") / 2), 225); 
            count=0;
            if(Keybord.isKeyPressed(KeyEvent.VK_SPACE)) screen = Enue.START;
            break;
            }

         gra.setColor(Color.BLACK);
             gra.setFont(new Font("SansSerif", Font.PLAIN, 1));
             gra.drawString(FPS + "", 0, 470);

             Frame.panel.draw();

            try {
                long runTime = System.currentTimeMillis() - startTime;
                if(runTime<(1000 / fps)) {
                    Thread.sleep((1000 / fps) - (runTime));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
}