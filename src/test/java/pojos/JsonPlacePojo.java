package pojos;

public class JsonPlacePojo {

    /*
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    //1- Obje icindeki tum variable`lari private olarak olusturduk
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2- Get and Set olusturduk
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3- Parametreli Constructor olusturduk
    public JsonPlacePojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4- Parametresiz Constructor olusturduk
    public JsonPlacePojo() {

    }

    // 5) toString() metodu olusturalim


    @Override
    public String toString() {
        return "JsonPlacePojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}

