package softwareengineering.utilities;

public class GoogleMapsApi {
    private String key = "AIzaSyAZSaSknz-_ghvGfzCZYq7TM8ObE3RIOhk";

    public String getUrl(String adresse) {
        String temp = adresse.replace(" ","+");
        return "https://www.google.com/maps/embed/v1/place?key=AIzaSyAZSaSknz-_ghvGfzCZYq7TM8ObE3RIOhk&q=" + temp;
    }
    public String getKey(){
        return key;
    }
}
