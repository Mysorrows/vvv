package util.Games;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by syimlzhu on 2017/1/13.
 */
public abstract class GamePlayerSocket implements IGamePlayer {

    private Socket socket;
    GamePlayerSocket(Socket socket) {
        this.socket = socket;
    }

    public int getInt() throws GameReadException{
        try {
            byte[] b = new byte[4];
            int len = socket.getInputStream().read(b);
            if(len!=4){
                throw new GameReadException();
            }
        } catch (IOException e) {
            throw new GameReadException();
        }
        return 0;
    }
    public void putInt(int a) throws GameReadException{
        try {
            byte[] b = new byte[4];
            b[0] = (byte) (a >> 24);
            b[0] = (byte) (a >> 16);
            b[0] = (byte) (a >> 8);
            b[0] = (byte) (a);
            socket.getOutputStream().write(b);
        }catch (IOException e){
            throw new GameReadException();
        }
    }
}
