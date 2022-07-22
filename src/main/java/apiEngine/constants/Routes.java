package apiEngine.constants;

public class Routes {
    public static final String BOOKSTORE= "/BookStore";
    public static final String ACCOUNT= "/Account";
    public static final String VERSION= "/v1";

    public static String getGenerateToken(){
        return ACCOUNT + VERSION + "/GenerateToken";
    }

    public static String books() {
        return BOOKSTORE + VERSION + "/Books";
    }

    public static String book(){
        return BOOKSTORE + VERSION + "/Book";
    }
}
