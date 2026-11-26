class Solution {
    public boolean canAliceWin(int n) {
        int stonesToRemove = 10;
        boolean aliceTurn = true;
        
        while (n >= stonesToRemove) {
            n -= stonesToRemove;
            stonesToRemove--;
            aliceTurn = !aliceTurn;
        }
        
        // If it is NOT Alice's turn when the game stops, Bob ran out of moves, so Alice wins.
        return !aliceTurn;
    }
}