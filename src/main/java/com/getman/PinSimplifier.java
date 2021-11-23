package com.getman;

public class PinSimplifier {
    private final int SIDE_LENGTH = 3;
    private final int[][] numpad;
    private int x = 1;
    private int y = 1;

    public static void main(String[] args) {
        String[] instructions = {
                "RLRLLLULULULUUDUULULRDDLURURDDLDUUDDLRDDUUUDD",
                "LDLRLDDDLUDRDRRUDUURLRULLUDDRLURLUULDLLRLLUDLRLRUDLULRLRRL",
                "DULRRDRLRLUDLLURURLLRLRDLLDLLDRDUURL",
                "DUULULUUDUDLLRLRURULLDLRRLURDLLDUDUDDRURRLUDULULD"
        };
        System.out.println(new PinSimplifier().pin(instructions));
    }

    public PinSimplifier() {
        numpad = new int[SIDE_LENGTH][SIDE_LENGTH];

        for(int i = 0; i < SIDE_LENGTH; i++) {
            for(int j = 0; j < SIDE_LENGTH; j++){
                numpad[i][j] = i*SIDE_LENGTH + (j+1);
            }
        }
    }

    public int pin(String[] instructions) {
        int pin = 0;
        for(int i = 0; i < instructions.length; i++){
            countCoordinates(instructions[i]);
            int digit = numpad[y][x];
            pin = append(pin, digit);
        }
        return pin;
    }

    private void countCoordinates(String instruction) {
        for(int i = 0; i < instruction.length(); i++) {
            char letter = instruction.charAt(i);
            switch (letter) {
                case 'L':
                    if(x != 0) x--;
                    break;
                case 'R':
                    if(x != 2) x++;
                    break;
                case 'U':
                    if(y != 0) y--;
                    break;
                case 'D':
                    if(y != 2) y++;
                    break;
                default:
                    break;
            }
        }
    }

    private int append(int pin, int digit) {
        return pin * 10 + digit;
    }
}
