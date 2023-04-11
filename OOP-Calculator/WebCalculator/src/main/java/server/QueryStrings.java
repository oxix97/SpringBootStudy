package server;

import java.util.ArrayList;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String line) {
        String[] tokens = line.split("&");
        for (String t : tokens) {
            String[] tmp = t.split("=");
            if (tmp.length != 2) throw new IllegalArgumentException("잘못된 query 입니다.");
            queryStrings.add(new QueryString(tmp[0], tmp[1]));
        }
    }

    public String getValue(String key) {
        return this.queryStrings.stream().filter(it -> it.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근"));

    }
}
