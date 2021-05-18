package Lesson_9;

import java.util.ArrayList;

public class Lesson_9_4_start {

    static class Resource
    {
        public volatile Integer BigNumber;
    }

    static ArrayList<String> logger;
    static class Player extends Thread
    {
        Player(Resource n)
        {
            res = n;
        }
        Resource res;
        @Override
        public void run() {
            while (res.BigNumber < 20) {
                res.BigNumber++;
                logger.add(this.getName());
            }
        }
    }

    public static void main(String[] args)
    {
        int playern = 5;
        Player[] players = new Player[playern];
        logger = new ArrayList<>();
        Resource res = new Resource();
        res.BigNumber=0;

        for (int i=0; i<playern ; i++)
        {
            players[i] = new Player(res);
        }

        for (int i=0;i<playern;i++)
        {
            players[i].start();
        }

        for (int i=0;i<playern;i++)
        {
            try {
                players[i].join();
            }
            catch (Exception e){}
        }

        System.out.println(res.BigNumber);
        for (int i=0;i<logger.size();i++)
        {
            System.out.println(i + " : " + logger.get(i));
        }
    }
}
