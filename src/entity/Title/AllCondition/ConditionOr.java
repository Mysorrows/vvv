package entity.Title.AllCondition;

import entity.Title.title_value;
import net.sf.json.JSONArray;
import util.Event.BaseEvent;
import util.Event.BaseTitleEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QAQ on 2017/5/29.
 */
public class ConditionOr extends BaseCondition{
    private List<BaseCondition> conditions;

    public ConditionOr(JSONArray ja) {
        conditions = new ArrayList<>();
        for(int i=0;i<ja.size();i++){
            conditions.add(BaseCondition.getCondition(ja.getJSONObject(i)));
        }
    }

    @Override
    public void setTitleID(int id) {
        for (BaseCondition condition : conditions) condition.setTitleID(id);
        super.setTitleID(id);
    }

    @Override
    public boolean check(BaseTitleEvent event) {
        for (BaseCondition condition : conditions) {
            if (condition.check(event)) return true;
        }
        return false;
    }
}
