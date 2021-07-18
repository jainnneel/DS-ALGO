import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class WebScrapingTest {

    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        
        try {
            // fetch the document over HTTP
            Document doc = Jsoup.connect("https://www.amazon.in/s?k=washing machine&ref=nb_sb_noss_2").get();
//            https://www.amazon.in/s?k=headphone&ref=nb_sb_noss_2
            // get the page title
            String title = doc.title();
            System.out.println("title: " + title);
           
            // get all links in page
            Elements links = doc.getElementsByAttribute("data-asin");
            System.out.println(links.size());
//            System.out.println(links.get(0).getElementsByClass("a-section a-spacing-none").text());
//            System.out.println(links.get(0).getElementsByClass("a-price-whole").text());
//            System.out.println(links.get(0).getElementsByClass("a-icon-alt").text());
            for (Element link : links) {
                if (link.hasAttr("data-index")) {
                    System.out.println(link.attr("data-index"));
                    System.out.println(link.getElementsByClass("a-size-mini a-spacing-none a-color-base s-line-clamp-2").text());
                    System.out.println(link.getElementsByClass("a-price-whole").text());
                    System.out.println(link.getElementsByClass("a-icon-alt").text());
//                    break;
                    System.out.println();
                    System.out.println();
                }
//                System.out.println(link);
            }
          } catch (IOException e) {
          e.printStackTrace();
          }
        
        
//        WebClient client = new WebClient();
//        client.getOptions().setCssEnabled(false);
//        client.getOptions().setJavaScriptEnabled(false);
//        String productUrl = "https://www.asos.com/the-north-face/the-north-face-vault-backpack-28-litres-in-black/prd/10253008";
//                
//        HtmlPage page = client.getPage(productUrl);
//        HtmlElement productNode = ((HtmlElement) page
//                        .getFirstByXPath("//*[@itemtype='https://schema.org/Product']"));
//        URL imageUrl = new URL((((HtmlElement) productNode.getFirstByXPath("./img")))
//                        .getAttribute("src"));
//        HtmlElement offers = ((HtmlElement) productNode.getFirstByXPath("./span[@itemprop='offers']"));
//                
//        BigDecimal price = new BigDecimal(((HtmlElement) offers.getFirstByXPath("./span[@itemprop='price']")).asText());
//        String productName = (((HtmlElement) productNode.getFirstByXPath("./span[@itemprop='name']")).asText());
//        String currency = (((HtmlElement) offers.getFirstByXPath("./*[@itemprop='priceCurrency']")).getAttribute("content"));
//        String productSKU = (((HtmlElement) productNode.getFirstByXPath("./span[@itemprop='sku']")).asText());
                
//        System.out.println("pricr:" + price);
    }
}
