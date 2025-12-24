import java.util.*;

public class GameLogic {
    private int[][] moves;
    private HashMap<String,List<List<Integer>>> map=new HashMap<>();
    public void markMoves(String[][] blocks){
        moves=new int[9][2];
        int k=0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if(blocks[i][j].equals("X") || blocks[i][j].equals("O")){
                    moves[k][0]=i;
                    moves[k][1]=j;
                    k++;
                }
            }
        }
    }
    public String whoIsWinner(String[][] blocks){
        map.clear();
        moves=new int[9][2];
        markMoves(blocks);
        map.put("X",new ArrayList<>());
        map.put("O",new ArrayList<>());
        for (int i = 0; i < moves.length; i++) {
            String key = blocks[moves[i][0]][moves[i][1]];
            if(key.isEmpty()){continue;}
            List<Integer> move=new ArrayList<>();
            move.add(moves[i][0]);
            move.add(moves[i][1]);
            map.get(key).add(move);
        }
        int[][] wins = {
                {0,0, 0,1, 0,2},
                {1,0, 1,1, 1,2},
                {2,0, 2,1, 2,2},

                {0,0, 1,0, 2,0},
                {0,1, 1,1, 2,1},
                {0,2, 1,2, 2,2},

                {0,0, 1,1, 2,2},
                {0,2, 1,1, 2,0}

        };
        Set<String> xSet=new HashSet<>();
        Set<String> oSet=new HashSet<>();

        for(List<Integer> xMove:map.get("X")){
            xSet.add(xMove.get(0)+","+xMove.get(1));
        }
        for(List<Integer> oMove:map.get("O")){
            oSet.add(oMove.get(0)+","+oMove.get(1));
        }
        for(int[] win:wins){
            String a=win[0]+","+win[1];
            String b=win[2]+","+win[3];
            String c=win[4]+","+win[5];

            if (xSet.contains(a) && xSet.contains(b) && xSet.contains(c)){
                return "X";
            }

            if (oSet.contains(a) && oSet.contains(b) && oSet.contains(c)){
                return "O";
            }
        }
        return "";
    }
}
