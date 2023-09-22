public class Article {

    private int views;

    private int id;

    private String title;

    private String content;

    private String legDate;

    public Article(int id,String title,String content, String legDate){
        this.title = title;
        this.content = content;
        this.legDate = legDate;
        this.id = id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegDate() {
        return legDate;
    }

    public void setLegDate(String legDate) {
        this.legDate = legDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}





























