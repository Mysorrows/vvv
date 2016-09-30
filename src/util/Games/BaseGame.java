package util.Games;

import net.sf.json.JSONObject;

/**
 * Created by syimlzhu on 2016/9/30.
 */
public abstract class BaseGame<T extends BaseGameStep> {
    /**
     * @return
     */
    public abstract JSONObject getRecord();

    /**
     * @param step
     * @return
     */
    public abstract int setStep(T step);
}
