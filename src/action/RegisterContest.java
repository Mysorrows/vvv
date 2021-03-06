package action;

import entity.Contest;
import entity.Contest_Type;
import servise.ContestMain;
import util.Main;

/**
 * Created by Syiml on 2015/7/4 0004.
 */

public class RegisterContest  extends BaseAction{
    public String cid;
    public String prefix;
    public String username;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPrefix() {

        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String regCon(){
        int cidInt=Integer.parseInt(cid);
        return ContestMain.registerContest(cidInt);
    }

    public String computeUsernamePassword(){
        int cidInt=Integer.parseInt(cid);
        Contest contest = ContestMain.getContest(cidInt);
        if(contest.getType() == Contest_Type.TEAM_OFFICIAL){
            contest.computeUsernamePassword(prefix);
            return "success";
        }
        return "success";
    }
    public String computeOneUseranemPassword(){
        int cidInt = Integer.parseInt(cid);
        Contest contest = ContestMain.getContest(cidInt);
        if(contest.getType() == Contest_Type.TEAM_OFFICIAL){
            contest.computeOneUsernamePassword(username);
        }
        return "success";
    }
}
