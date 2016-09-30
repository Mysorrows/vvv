package util.Games.GoBang;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Games.BaseGame;
import util.JSON.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 1表示黑子，2表示白子
 * 黑子先下
 * Created by syimlzhu on 2016/9/30.
 */
public class GameGoBang extends BaseGame<GameGoBangStep>{
    private int row;
    private int col;
    private int chessBoard[][];
    private int nowPlayer;
    private JSONObject record;

    public GameGoBang(int row,int col){
        this.row = row;
        this.col = col;
        chessBoard = new int[row][];
        for(int i=0;i<row;i++){
            chessBoard[i]=new int[col];
            for(int j=0;j<col;j++){
                chessBoard[i][j] = 0;
            }
        }
        record = new JSONObject();
        record.put("type","GoBang");
        record.put("row",row);
        record.put("col",col);
        record.put("step",new JSONArray());
    }

    @Override
    public int setStep(GameGoBangStep step) {
        return set(step.x,step.y);
    }

    /**
     * 在位置i,j下一枚子
     * 返回胜利方
     * 如果当前方下在非法位置，直接判负
     * @param i 位置坐标i
     * @param j 位置坐标j
     * @return 0未分胜负，可以继续
     *         1黑方五连珠胜
     *         2白方五连珠胜
     *         3白方下子非法，黑方胜
     *         4黑方下子非法，白方胜
     *         -1平局
     */
    public int set(int i,int j){
        JSONObject aStep = new JSONObject();
        aStep.put("x",i);
        aStep.put("y",j);
        record.getJSONArray("step").add(aStep);

        if(i<0||i>=row||j<0||j>col||chessBoard[i][j] != 0){
            if(nowPlayer == 1){
                return 4;
            }else{
                return 3;
            }
        }
        chessBoard[i][j] = nowPlayer;
        nowPlayer = 3 - nowPlayer;
        return getVec(i,j);
    }

    private int getVec(int x,int y){
        int player = chessBoard[x][y];
        int next[][] = {
                {0,1},
                {1,1},
                {1,0},
                {1,-1}
        };
        for (int[] aNext : next) {
            int nowLength = 1;
            int nx = x, ny = y;
            while (true) {
                nx += aNext[0];
                ny += aNext[1];
                if (nx < 0 || nx >= row || ny < 0 || ny <= col || chessBoard[nx][ny] != player) {
                    break;
                } else {
                    nowLength++;
                }
            }
            while (true) {
                nx -= aNext[0];
                ny -= aNext[1];
                if (nx < 0 || nx >= row || ny < 0 || ny <= col || chessBoard[nx][ny] != player) {
                    break;
                } else {
                    nowLength++;
                }
            }
            if(nowLength>=5) return player;
        }
        return -1;
    }

    public JSONObject getRecord(){
        return record;
    }

}
