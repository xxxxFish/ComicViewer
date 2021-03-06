package ljw.comicviewer.bean;

import java.util.List;

/**
 * Created by ljw on 2017-08-23 023.
 */

public class Comic {
    private String comicId;
    private String name;//漫画名
    private String author;//作者
    private List<Author> authors;//作者,便于查询他(们)的作品
    private String imageUrl;//封面图片地址
    private String update;//更新日期
    private String updateStatus;//更新情况 如：更新至第1话
    private boolean isEnd;//漫画状态：连载还是完结
    private String score;//评分
    private String info;//简介
    private boolean ban;//屏蔽情况
    private String tag;
    private List<Chapter> Chapters;
    private String comeFrom;

    public Comic() {
    }

    public String getComicId() {
        return comicId;
    }

    public void setComicId(String comicId) {
        this.comicId = comicId;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }


    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Chapter> getChapters() {
        return Chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        Chapters = chapters;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + comicId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", authors='" + listAuthor() + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", update='" + update + '\'' +
                ", updateStatus='" + updateStatus + '\'' +
                ", isEnd=" + isEnd +
                ", score='" + score + '\'' +
                ", info='" + info + '\'' +
                ", ban=" + ban +
                ", tag='" + tag + '\'' +
                ", Chapters_Size='" + (Chapters==null? "null" : Chapters.size()) + '\'' +
                ", comeFrom=" + comeFrom +
                '}';
    }

    private String listAuthor(){
        String str = "[";
        if (authors!=null){
            for(Author a : authors){
                str += a.toString() + ",";
            }
            return str.substring(0,str.length()-1)+"]";
        }
        return null;
    }
}
