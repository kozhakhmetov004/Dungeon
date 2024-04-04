package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameField extends JPanel {
    private final int DOT_SIZE = 64;

    private int x =DOT_SIZE;
    private int y =DOT_SIZE;
    private boolean alive=true;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private Image personRight;
    private Image personLeft;
    private Image personUp;
    private Image personDown;
    private Image personRight2;
    private Image personLeft2;
    private Image personUp2;
    private Image personDown2;
    private Image personRight3;
    private Image personLeft3;
    private Image personUp3;
    private Image personDown3;
    private Image rock;
    private Image block;
    private Image spike;
    private int[][] blocks;
    private Image bush;
    private Random rand = new Random();
    private int steps=1;
    private int cash = 0;
    private Image chestopen;
    private Image chestclosed;
    private Image Shield;
    private Image Shield2;
    private Image Shield3;
    private Image Shield1;
    private int chestX;
    private int chestY;
    private boolean chestopened;
    int Roomwidth=rand.nextInt(11)+5;
    int Roomheight=rand.nextInt(5)+5;
    private int spikecount=rand.nextInt(5);
    private int[][] spikes = new int[spikecount][2];
    private int hp = 6;
    private ArrayList<Integer> doorsX = new ArrayList<>();
    private ArrayList<Integer> doorsY = new ArrayList<>();
    private Image hearts;
    private Image halfhearts;
    private Image GameOverBG;
    private Image CashBG;
    private Image Door;
    private boolean shielded=false;
    private static Timer timer;



    public GameField(){

        setSize(1474,800);
        setLayout(null);
        addKeyListener(new KeyListener(){});
        setFocusable(true);
        LoadImages();
        chestX=(rand.nextInt(Roomwidth-1)+1)*DOT_SIZE;
        chestY=(rand.nextInt(Roomheight-1)+1)*DOT_SIZE;
        for (int i =0;i<spikecount;i++){
            int randomX = (rand.nextInt(Roomwidth-1)+1)*DOT_SIZE;
            int randomY = (rand.nextInt(Roomheight-1)+1)*DOT_SIZE;
            spikes[i][0]=randomX;
            spikes[i][1]=randomY;
        }



    }



    private void LoadImages() {
        ImageIcon r = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\right.png");
        personRight = r.getImage();
        ImageIcon l = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\left.png");
        personLeft = l.getImage();
        ImageIcon u = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\up.png");
        personUp = u.getImage();
        ImageIcon d = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\down.png");
        personDown = d.getImage();
        ImageIcon rockii = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\rock.png");
        rock = rockii.getImage();
        ImageIcon blockii = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\block.png");
        block = blockii.getImage();
        ImageIcon bushii = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\bush.png");
        bush = bushii.getImage();
        ImageIcon r2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\right2.png");
        personRight2 = r2.getImage();
        ImageIcon l2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\left2.png");
        personLeft2 = l2.getImage();
        ImageIcon u2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\up2.png");
        personUp2 = u2.getImage();
        ImageIcon d2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\down2.png");
        personDown2 = d2.getImage();
        ImageIcon r3= new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\right3.png");
        personRight3 = r3.getImage();
        ImageIcon l3 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\left3.png");
        personLeft3 = l3.getImage();
        ImageIcon u3 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\up3.png");
        personUp3 = u3.getImage();
        ImageIcon d3 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\down3.png");
        personDown3 = d3.getImage();
        ImageIcon chest1 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\chest1.png");
        chestclosed = chest1.getImage();
        ImageIcon chest2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\chest2.png");
        chestopen = chest2.getImage();
        ImageIcon spikess = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\spikes.png");
        spike = spikess.getImage();
        ImageIcon heartsIm = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\heart.png");
        hearts = heartsIm.getImage();
        ImageIcon halfheartsIm = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\halfheart.png");
        halfhearts = halfheartsIm.getImage();
        ImageIcon bg = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\GameOverBG.png");
        GameOverBG = bg.getImage();
        ImageIcon bg2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\cashbg.png");
        CashBG = bg2.getImage();
        ImageIcon door = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\door.png");
        Door = door.getImage();
        ImageIcon shield = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\shield4.png");
        Shield = shield.getImage();
        ImageIcon shield2 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\shield2.png");
        Shield2 = shield2.getImage();
        ImageIcon shield3 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\shield3.png");
        Shield3 = shield3.getImage();
        ImageIcon shield1 = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\shield1.png");
        Shield1 = shield1.getImage();
    }

    class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_A){
                left=true;
                up=false;
                down=false;
                right=false;
                checkCollisions();
                move();
                steps++;
            }if(key == KeyEvent.VK_D){
                right=true;
                up=false;
                down=false;
                left=false;
                checkCollisions();
                move();
                steps++;
            }if(key == KeyEvent.VK_W){
                up=true;
                left=false;
                right=false;
                down=false;
                checkCollisions();
                move();
                steps++;
            }if(key == KeyEvent.VK_S){
                down=true;
                left=false;
                right=false;
                up=false;
                checkCollisions();
                move();
                steps++;
            }if(key == KeyEvent.VK_SPACE){
                checkInteractions();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 40; j++) {
                g.drawImage(rock, i * DOT_SIZE, j * DOT_SIZE, this);
            }
        }
        blocks=new int[Roomwidth*2+Roomheight*2][2];
        for(int i=0;i<Roomwidth+1;i++){
            g.drawImage(block,i*DOT_SIZE,0, this);
            g.drawImage(block,i*DOT_SIZE, Roomheight * DOT_SIZE, this);
            blocks[i][0]=i*DOT_SIZE;
            blocks[i][1]=0;
            blocks[i+Roomwidth][0]=i*DOT_SIZE;
            blocks[i+Roomwidth][1]=Roomheight*DOT_SIZE;
        }
        for (int i=1;i<Roomheight;i++){
            g.drawImage(block,0,i*DOT_SIZE, this);
            g.drawImage(block,Roomwidth*DOT_SIZE, i * DOT_SIZE, this);
            blocks[2*Roomwidth+i][0]=0;
            blocks[2*Roomwidth+i][1]=i*DOT_SIZE;
            blocks[2*Roomwidth+Roomheight-2+i][0]=Roomwidth*DOT_SIZE;
            blocks[2*Roomwidth+Roomheight-2+i][1]=i*DOT_SIZE;
        }
        for (int i =0;i<spikecount;i++){
            g.drawImage(spike,spikes[i][0],spikes[i][1],this);
        }
        if(doorsX.size()==0) {
            int randblock = rand.nextInt(blocks.length);
            if(blocks[randblock][0]<1 || blocks[randblock][1]<1){
                randblock = rand.nextInt(blocks.length);
            }
            doorsX.add(blocks[randblock][0]);
            doorsY.add(blocks[randblock][1]);
            System.out.println(doorsX);
            System.out.println(doorsY);
            blocks[randblock][0]=0;
            blocks[randblock][1]=0;
            System.out.println(blocks[randblock][0]+" "+blocks[randblock][1]);
        }

        g.drawImage(Shield1,192,0,this);

        g.drawImage(chestclosed,chestX,chestY,this);
        for(int i=0;i<doorsX.size();i++){
            g.drawImage(Door, doorsX.get(i) , doorsY.get(i), this);
        }
        if(hp%2==0) {
            for (int i = 0; i < hp / 2; i++) {
                g.drawImage(hearts, i * DOT_SIZE / 2, 0, this);
            }
        }else if(hp%2==1){
            for (int i = 0; i < hp / 2; i++) {
                g.drawImage(hearts, i * DOT_SIZE / 2, 0, this);
            }
            g.drawImage(halfhearts,(hp-1)/2*DOT_SIZE/2,0,this);
        }
        if(hp<1){
            alive=false;
        }
        int s = -10;
        g.setColor(new Color(166,120,19));
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawImage(CashBG,1474,0,this);
        g.drawString(String.valueOf(cash),1484-s,20);
        repaint();

        if(alive){
            if(right){
                if(steps%4==2) {
                    g.drawImage(personRight2, x, y, this);
                }else if(steps%4==0){
                    g.drawImage(personRight3, x, y, this);
                }else{
                    g.drawImage(personRight, x, y, this);
                }
            }if(left){
                if(steps%4==2) {
                    g.drawImage(personLeft2, x, y, this);
                }else if(steps%4==0){
                    g.drawImage(personLeft3, x, y, this);
                }else{
                    g.drawImage(personLeft, x, y, this);
                }
            }if(up){
                if(steps%4==2) {
                    g.drawImage(personUp2, x, y, this);
                }else if(steps%4==0){
                    g.drawImage(personUp3, x, y, this);
                }else{
                    g.drawImage(personUp, x, y, this);
                }
            }if(down){
                if(steps%4==2) {
                    g.drawImage(personDown2, x, y, this);
                }else if(steps%4==0){
                    g.drawImage(personDown3, x, y, this);
                }else{
                    g.drawImage(personDown, x, y, this);
                }
            }


        }else{
            g.drawImage(GameOverBG,0,0,this);
            String str = "GAME OVER";
            Font f = null;
            try {
                f = Font.createFont(Font.TRUETYPE_FONT,new File("C:\\Users\\Asus\\IdeaProjects\\Dungeon\\src\\Resources\\f.ttf")).deriveFont(150f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("f.ttf")));
            } catch (IOException |FontFormatException e) {

            }
            g.setColor(Color.RED);
            g.setFont(f);
            g.drawString(str,470,500);
        }
    }

    public void move(){
        if(alive){

            if(right){
                if(x<1296) {
                    x += DOT_SIZE/4;
                }
            }if(left){
                if(x>0) {
                    x -= DOT_SIZE/4;
                }
            }if(up){
                if(y>0) {
                    y -= DOT_SIZE/4;
                }
            }if(down){
                if(y<700) {
                    y += DOT_SIZE/4;
                }
            }
        }repaint();
    }

    public void checkCollisions(){
        for(int i=0;i<blocks.length;i++) {
            if (x+DOT_SIZE/4<blocks[i][0]+DOT_SIZE && x+DOT_SIZE>=blocks[i][0] && y > blocks[i][1]-DOT_SIZE && y <blocks[i][1]+DOT_SIZE && right) {
                x -= DOT_SIZE/4;
            }
            else if (x-DOT_SIZE/4<blocks[i][0]+DOT_SIZE && x-DOT_SIZE>=blocks[i][0] && y > blocks[i][1]-DOT_SIZE && y <blocks[i][1]+DOT_SIZE && left) {
                x += DOT_SIZE/4;
            }
            else if (x<blocks[i][0]+DOT_SIZE && x>blocks[i][0]-DOT_SIZE && y+DOT_SIZE >= blocks[i][1] && y+DOT_SIZE/4 <blocks[i][1]+DOT_SIZE && down) {
                y -= DOT_SIZE/4;
            }
            else if (x<blocks[i][0]+DOT_SIZE && x>blocks[i][0]-DOT_SIZE && y-DOT_SIZE >= blocks[i][1] && y-DOT_SIZE/4 <blocks[i][1]+DOT_SIZE && up) {
                y += DOT_SIZE/4;
            }
        }
        if (x+DOT_SIZE/4<chestX+DOT_SIZE && x+DOT_SIZE>=chestX && y > chestY-DOT_SIZE && y <chestY+DOT_SIZE && right) {
            x -= DOT_SIZE/4;
        }
        else if (x-DOT_SIZE/4<chestX+DOT_SIZE && x-DOT_SIZE>=chestX && y > chestY-DOT_SIZE && y <chestY+DOT_SIZE && left) {
            x += DOT_SIZE/4;
        }
        else if (x<chestX+DOT_SIZE && x>chestX-DOT_SIZE && y+DOT_SIZE >= chestY && y+DOT_SIZE/4 <chestY+DOT_SIZE && down) {
            y -= DOT_SIZE/4;
        }
        else if (x<chestX+DOT_SIZE && x>chestX-DOT_SIZE && y-DOT_SIZE >= chestY && y-DOT_SIZE/4 <chestX+DOT_SIZE && up) {
            y += DOT_SIZE/4;
        }if(!shielded) {
            for (int i = 0; i < spikes.length; i++) {
                if (x + DOT_SIZE / 4 < spikes[i][0] + DOT_SIZE && x + DOT_SIZE >= spikes[i][0] && y > spikes[i][1] - DOT_SIZE && y < spikes[i][1] + DOT_SIZE && right) {
                    hp--;
                    shielded=true;
                    GameField.super.getGraphics().(Shield1,1,192,0,32,32);
                    timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            shielded=false;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (x - DOT_SIZE / 4 < spikes[i][0] + DOT_SIZE && x - DOT_SIZE >= spikes[i][0] && y > spikes[i][1] - DOT_SIZE && y < spikes[i][1] + DOT_SIZE && left) {
                    hp--;
                    shielded=true;
                    GameField.super.imageUpdate(Shield1,1,192,0,32,32);
                    timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            shielded=false;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (x < spikes[i][0] + DOT_SIZE && x > spikes[i][0] - DOT_SIZE && y + DOT_SIZE >= spikes[i][1] && y + DOT_SIZE / 4 < spikes[i][1] + DOT_SIZE && down) {
                    hp--;
                    shielded=true;
                    GameField.super.imageUpdate(Shield1,1,192,0,32,32);
                    timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            shielded=false;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (x < spikes[i][0] + DOT_SIZE && x > spikes[i][0] - DOT_SIZE && y - DOT_SIZE >= spikes[i][1] && y - DOT_SIZE / 4 < spikes[i][1] + DOT_SIZE && up) {
                    hp--;
                    shielded=true;
                    GameField.super.imageUpdate(Shield1,1,192,0,32,32);
                    timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            shielded=false;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }


            }
        }
    }

    public void checkInteractions(){
        if(x+DOT_SIZE==chestX && y==chestY){
            chestclosed=chestopen;
        }if(x-DOT_SIZE==chestX && y==chestY){
            chestclosed=chestopen;
        }if(x==chestX && y+DOT_SIZE==chestY){
            chestclosed=chestopen;
        }if(x==chestX && y-DOT_SIZE==chestY){
            chestclosed=chestopen;
        }
        if(chestclosed==chestopen && !chestopened){
            cash+=rand.nextInt(15)*5;
            int heartfromchest=rand.nextInt(5);
            if(heartfromchest==1 || heartfromchest==2){
                if(hp+1<=6){
                    hp++;
                }
            }
            chestopened=true;
        }
        repaint();
    }



}
