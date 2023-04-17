package server;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String path;
    private QueryStrings query;

    public RequestLine(String method, String path, String queryString) {
        this.method = method;
        this.path = path;
        this.query = new QueryStrings(queryString);
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        String[] urlPathTokens = tokens[1].split("\\?");
        this.method = tokens[0];
        this.path = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.query = new QueryStrings(urlPathTokens[1]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(path, that.path) && Objects.equals(query, that.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path, query);
    }

    public RequestLine(String method, String path, QueryStrings query) {
        this.method = method;
        this.path = path;
        this.query = query;
    }

    public boolean isGetRequest() {
        return this.method.equals("GET");
    }

    public boolean isMatchPath(String s) {
        return this.path.equals(s);
    }

    public QueryStrings getQueryStrings() {
        return this.query;
    }


}
