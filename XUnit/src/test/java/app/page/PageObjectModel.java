package app.page;

import java.util.HashMap;
import java.util.List;

public class PageObjectModel {
    /**
     * 定义element接收
     */
    public HashMap<String, PageObjectElement> elements = new HashMap<>();
    /**
     * 定义method接收
     */
    public HashMap<String, PageObjectMethod> methods = new HashMap<>();
}
