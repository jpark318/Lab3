import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


/**
 * Gets the distance between tw points.
 */
public class LabFile {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        String textFromUrl;
        int countWord = 0;
        boolean stillWord = false;
        textFromUrl = urlToString("http://erdani.com/tdpl/hamlet.txt");
        while (textFromUrl.length() != 1) {
            if ((textFromUrl.charAt(0) != ' ') && (textFromUrl.charAt(0) != '\n')) {
                if (!stillWord) {
                    countWord++;
                    stillWord = true;
                }
            } else {
                stillWord = false;
            }

            textFromUrl = textFromUrl.substring(1);
        }
        System.out.println(countWord);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}

