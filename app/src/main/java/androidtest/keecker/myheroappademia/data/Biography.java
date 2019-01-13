package androidtest.keecker.myheroappademia.data;

import java.io.Serializable;
import java.util.List;

public class Biography implements Serializable {
    private String fullName;
    private List<String> aliases;
    private String publisher;

    public Biography() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliase(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
