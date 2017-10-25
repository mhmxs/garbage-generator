package com.blogspot.com.jpattern.garbagegenerator;

public class Main {

    public static void main(String[] args) {
        Config config = new Config();
        for (String arg : args) {
            if (arg.startsWith("-h")) {
                System.out.println("-h help\n-dXXXX divisor\n-pXXX produce in ms\n-cXXX number of consumers");
                System.exit(0);
            } else if (arg.startsWith("-d")) {
                config.divisor = Integer.parseInt(arg.substring(2));
            } else if (arg.startsWith("-p")) {
                config.produce = Integer.parseInt(arg.substring(2));
            } else if (arg.startsWith("-c")) {
                config.consumers = Integer.parseInt(arg.substring(2));
            }
        }
        try {
            new Runner().run(config);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Config {
        public int divisor = 5000;
        public int produce = 50;
        public int consumers = 16;
    }
}
