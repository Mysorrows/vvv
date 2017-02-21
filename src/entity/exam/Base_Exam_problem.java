package entity.exam;

import entity.IBeanCanCatch;
import entity.IBeanResultSetCreate;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 试题基类
 * Created by QAQ on 2016/5/25 0025.
 */
public class Base_Exam_problem implements IBeanResultSetCreate, IBeanCanCatch {
    public JSONObject data;
    protected int id;
    protected String title;
    protected ExamProblemType type;
    protected int score;
    protected String createUser;
    protected int isPublic;
    private Timestamp catch_time;

    public Base_Exam_problem(){

    }

    public void init(ResultSet rs) throws SQLException {
        id = rs.getInt("id");
        type = ExamProblemType.getByCode(rs.getInt("type"));
        data = JSONObject.fromObject(rs.getString("data"));
        title = rs.getString("title");
        createUser = rs.getString("user");
        isPublic = rs.getInt("public");
        score = 0;
    }

    protected Base_Exam_problem initFromJson(JSONObject jo){
        return null;
    }

    protected String toJSON(){
        return null;
    }

    protected Base_Exam_problem copy(Base_Exam_problem base){
        this.title=base.title;
        this.score=base.score;
        this.type=base.type;
        this.createUser=base.createUser;
        this.isPublic=base.isPublic;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExamProblemType getType() {
        return type;
    }

    public void setType(ExamProblemType type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCreateUser() {
        return createUser;
    }

    public int getIsPublic() {
        return isPublic;
    }

    @Override
    public Timestamp getExpired() {
        return catch_time;
    }

    @Override
    public void setExpired(Timestamp t)  {
        catch_time = t;
    }
}
