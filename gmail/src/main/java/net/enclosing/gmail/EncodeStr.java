package net.enclosing.gmail;
import java.io.UnsupportedEncodingException;

public class EncodeStr {

    public EncodeStr() {

    }

    public String utf82Iso2022jp(String utf8str) {

        String iso2022jpStr;
        try {
            iso2022jpStr = new String(utf8str.getBytes("ISO-2022-JP"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return utf8str;
        }

        return iso2022jpStr;

    }

    public String utf82Eucjp(String utf8str) {

        String eucjpStr;
        try {
            eucjpStr = new String(utf8str.getBytes("EUC-JP"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return utf8str;
        }

        return eucjpStr;

    }
}
