import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class JsoupSample {
    public static void main(String[] args) throws IOException {
        
        //   url を指定する場合     
        String url = args[0];
        Document doc = Jsoup.connect(url).get();

//         // path を指定する場合
//         File f = new File(args[0]);
//         Document doc = Jsoup.parse(f, "UTF-8"); 

        // 余計な整形はしないようにする
        doc.outputSettings().prettyPrint(false);

        // タイトルの中身を標準出力へ
        System.out.printf("Title: %s%n", doc.title()); 

        // a タグの href と中身を標準出力へ
        Elements anchors = doc.select("a");
        for (Element anchor: anchors) {
            System.out.printf("Link: %s \t--- %s%n", anchor.absUrl("href"), anchor.html());
        }

        // b タグを strong タグに変換 
        for (Element elem: doc.select("b")) {
            elem.tagName("strong");
        }
        
        // h1を標準出力
        for (Element h1 : doc.select("h1")) {
            System.out.println("H1: " + h1.text());
        }

        // iタグをemタグに変換
        for (Element i: doc.select("i")) {
            i.tagName("em");
        }

        // ulタグの1つ目にclass=red
        for (Element ul : doc.select("ul")) {
            ul.child(0).addClass("red");
        }
        
        // olの最後に<li>...</li>
        for (Element ol : doc.select("ol")) {
            ol.appendElement("li").text("...");
        }

        // すべてのコメントを削除
        removeComments(doc);

        // すべての<p class='ignore'>タグをコメントアウト
        for (Element element : doc.select("p.ignore")) {
            String comment = "<!-- " + element.outerHtml() + " -->";
            element.after(comment);
            element.remove();
        }

        // Unix なら /tmp, Windows なら C:\Users\xxxx\AppData\Local\Temp\
        String tmpdir = System.getProperty("java.io.tmpdir");
        String outf   = "tmp.html";

        // 変換したものをファイルに保存
        File g = new File(new File(tmpdir), outf);
        try (FileWriter out = new FileWriter(g)) {
            out.write(doc.outerHtml());
            System.err.printf("output written to %s.%n", g.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        System.out.print(doc.outerHtml());
    }

    private static void removeComments(Node node) {
        for (int i = 0; i < node.childNodeSize();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment"))
                child.remove();
            else {
                removeComments(child);
                i++;
            }
        }
    }
}
