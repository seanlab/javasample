package me.seanxiao.interview;

import java.io.IOException;
import java.util.Scanner;

public class CircularBuffer {

    private static int BUFFER_SIZE;

    private static int lastIndex = 0;

    private static String[] buffer;

    private static void addToBuffer(String line) {
        if (lastIndex == BUFFER_SIZE) {
            for (int i = 1; i < BUFFER_SIZE; i++) {
                buffer[i - 1] = buffer[i];
            }
            lastIndex--;
        }
        buffer[lastIndex++] = line;
    }

    private static void removeFromBuffer(int index) {
        lastIndex = 0;
        for (int i = index; i < BUFFER_SIZE && buffer[i] != null; i++) {
            buffer[i - index] = buffer[i];
            lastIndex = i - index + 1;
        }
        for (int i = lastIndex; i < BUFFER_SIZE; i++) {
            buffer[i] = null;
        }
    }

    private static void printBuffer() {
        for (int i = 0; i < BUFFER_SIZE && buffer[i] != null; i++) {
            System.out.println(buffer[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        BUFFER_SIZE = Integer.parseInt(stdin.nextLine());
        String line = null;
        buffer = new String[BUFFER_SIZE];
        while ((line = stdin.nextLine()) != null) {
            String command = line.split(" ")[0];
            if ("A".equals(command)) {
                int length = Integer.parseInt(line.split(" ")[1]);
                for (int i = 0; i < length; i++) {
                    addToBuffer(stdin.nextLine());
                }
            }
            else if ("R".equals(command)) {
                int index = Integer.parseInt(line.split(" ")[1]);
                removeFromBuffer(index);
            }
            else if ("L".equals(command)) {
                printBuffer();
            }
            else if ("Q".equals(command)) {
                break;
            }
        }
        stdin.close();
    }
}
