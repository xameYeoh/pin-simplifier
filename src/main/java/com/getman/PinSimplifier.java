package com.getman;

public class PinSimplifier {
    private final int SIDE_LENGTH = 3;
    private final int[][] numpad;
    private int startCol = 1;
    private int startRow = 1;

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
            int[] directions = simplify(instructions[i]);
            int digit = determinePinDigitAndResetStartingLocation(directions);
            pin = append(pin, digit);
        }
        return pin;
    }

    private int[] simplify(String instruction) {
        int[] steps = countSteps(instruction);
        int rightCounter = steps[0];
        int upCounter = steps[1];

        int[] directions = {setEffectiveValue(rightCounter), setEffectiveValue(upCounter)};
        return directions;
    }

    private int[] countSteps(String instruction) {
        int upCounter = 0;
        int rightCounter = 0;

        for(int i = 0; i < instruction.length(); i++) {
            char letter = instruction.charAt(i);
            switch (letter) {
                case 'R':
                    rightCounter++;
                    break;
                case 'L':
                    rightCounter--;
                    break;
                case 'U':
                    upCounter++;
                    break;
                case 'D':
                    upCounter--;
                    break;
                default:
                    break;
            }
        }

        int[] inputDirections = {rightCounter, upCounter};
        return inputDirections;
    }

    private int setEffectiveValue(int counter) {
        if(counter >= SIDE_LENGTH) return SIDE_LENGTH - 1;
        if(counter <= -SIDE_LENGTH) return -SIDE_LENGTH + 1;
        return counter;
    }

    private int determinePinDigitAndResetStartingLocation(int[] directions) {
        int col = determineColumn(directions[0]);
        int row = determineRow(directions[1]);

        startCol = col;
        startRow = row;

        return numpad[row][col];
    }

    private int determineColumn(int steps) {
        int column = startCol + steps;
        if(column < 0) column = 0;
        if(column >= SIDE_LENGTH) column = SIDE_LENGTH - 1;

        return column;
    }

    private int determineRow(int steps) {
        int row = startRow - steps;
        if(row < 0) row = 0;
        if(row >= SIDE_LENGTH) row = SIDE_LENGTH - 1;

        return row;
    }

    private int append(int pin, int digit) {
        return pin * 10 + digit;
    }
}
