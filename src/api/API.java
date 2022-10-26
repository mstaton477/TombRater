package api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//TODO robustify

public class API implements APIInterface {

    private static final String FORMAT_STRING = "http%s://www.openlibrary.org/%s.json%s";

    public URL getUrl(RequestType _requestType, String _arg) throws IOException {
        return new URL(String.format(FORMAT_STRING, supportsHttps() ? "s" : "", _requestType + "/" + _arg, ""));
    }

    public URL getUrlSearch(RequestType _nullableRequestType, String _arg) throws IOException {
        return new URL(String.format(FORMAT_STRING, supportsHttps() ? "s" : "", "search" +
                (_nullableRequestType != null ? "/" + _nullableRequestType : ""),
                "?q=" + URLEncoder.encode(_arg, StandardCharsets.UTF_8)));
    }

    public HttpURLConnection getConnection(URL _url) throws IOException {
        return (HttpURLConnection) _url.openConnection();
    }
}

