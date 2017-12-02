package ljw.comicviewer.store;

import java.util.List;
import java.util.Map;

/**
 * Created by ljw on 2017-10-22 022.
 */

public class RuleStore {
    private final String TAG = this.getClass().getSimpleName()+"----";
    private static RuleStore ruleStore = null;
    private String host;
    private String domain;
    private String cookie;
    private String imgHost;
    private String currentRule;
    private Map<String,List<Map<String,String>>> typeRule;
    private Map<String,String> listRule;
    private Map<String,String> latestRule;
    private Map<String,String> detailsRule;
    private Map<String,String> searchRule;
    private Map<String,String> detailsChapterRule;

    private RuleStore(){}

    public static RuleStore get(){
        if(ruleStore == null){
            ruleStore = new RuleStore();
        }
        return ruleStore;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getImgHost() {
        return imgHost;
    }

    public void setImgHost(String imgHost) {
        this.imgHost = imgHost;
    }

    public String getCurrentRule() {
        return currentRule;
    }

    public void setCurrentRule(String currentRule) {
        this.currentRule = currentRule;
    }

    public Map<String, List<Map<String, String>>> getTypeRule() {
        return typeRule;
    }

    public void setTypeRule(Map<String, List<Map<String, String>>> typeRule) {
        this.typeRule = typeRule;
    }

    public Map<String, String> getListRule() {
        return listRule;
    }

    public void setListRule(Map<String, String> listRule) {
        this.listRule = listRule;
    }

    public Map<String, String> getLatestRule() {
        return latestRule;
    }

    public void setLatestRule(Map<String, String> latestRule) {
        this.latestRule = latestRule;
    }

    public Map<String, String> getDetailsRule() {
        return detailsRule;
    }

    public void setDetailsRule(Map<String, String> detailsRule) {
        this.detailsRule = detailsRule;
    }

    public Map<String, String> getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(Map<String, String> searchRule) {
        this.searchRule = searchRule;
    }

    public Map<String, String> getDetailsChapterRule() {
        return detailsChapterRule;
    }

    public void setDetailsChapterRule(Map<String, String> detailsChapterRule) {
        this.detailsChapterRule = detailsChapterRule;
    }
}
