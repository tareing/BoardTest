import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardText {
    static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {
        Article a1 = new Article(1, "첫번째예요", "내용이예요", legDate());
        Article a2 = new Article(2, "두번째예요", "내용이예요", legDate());
        Article a3 = new Article(3, "세번째예요", "내용이예요", legDate());

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);

        Scanner scan = new Scanner(System.in);
        int articleNum = 4;


        while (true) {
            System.out.print("명령어 :");
            String commend = scan.nextLine();
            if (commend.contains("exit")) {
                System.out.println("시스템 종료");
                break;
            } else if (commend.equals("add")) {
                System.out.print("제목 입력 :");
                String title = scan.nextLine();
                System.out.print("내용 입력 :");
                String content = scan.nextLine();

                Article article = new Article(articleNum, title, content, legDate());
                articles.add(article);
                System.out.println("게시물이 등록되었습니다.");
            } else if (commend.equals("list")) {
                printText(articles);
            } else if (commend.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                    int targetId = scan.nextInt();
                    scan.nextLine();
                    Article article = findby(targetId);

                    if (article == null) {
                        System.out.println("없는 게시물입니다");
                    } else {
                        System.out.print("제목 :");
                        String newTitle = scan.nextLine();
                        System.out.print("내용 :");
                        String newContent = scan.nextLine();

                        article.setTitle(newTitle);
                        article.setContent(newContent);
                        System.out.println("수정이 완료되었습니다");
                }
            } else if (commend.equals("delete")) {
                System.out.print("삭제할 게시물 번호 :");
                int targetId = scan.nextInt();
                scan.nextLine();

                Article article = findby(targetId);

                if (article == null) {
                    System.out.println("없는 게시물입니다");
                } else {
                    articles.remove(article);
                    System.out.println("게시물이 삭제되었습니다");
                }

            } else if (commend.equals("detail")) {
                System.out.print("상세보기할 게시물 번호 :");
                int targetId = scan.nextInt();
                scan.nextLine();

                Article article = findby(targetId);

                if (article == null) {
                    System.out.println("없는 게시물번호입니다.");
                } else {

                    article.setViews(article.getViews() + 1);

                    System.out.println("===================================");
                    System.out.printf("등록일 %s\n", article.getLegDate());
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.printf("조회수 : %d\n", article.getViews());
                    System.out.println("===================================");

                }
            } else if (commend.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String key = scan.nextLine();

                ArrayList<Article> searched = new ArrayList<>();

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    String title = article.getTitle();

                    if (title.contains(key)) {
                        searched.add(article);
                    }
                }
                printText(searched);
            }


        }

    }


    public static Article findby(int id) {
        Article target = null;
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }


    public static void printText(ArrayList<Article> list) {
        System.out.println("==========================");
        for (int i = 0; i < list.size(); i++) {
            Article article = list.get(i);
            System.out.printf("번호 : %d\n", article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());


            System.out.println("========================");
        }
    }


    public static String legDate() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formatedNow = now.format(formatter);

        return formatedNow;

    }

}
