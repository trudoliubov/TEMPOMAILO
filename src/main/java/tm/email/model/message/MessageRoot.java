package tm.email.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageRoot {
    @JsonProperty("@context")
    public String context;

    @JsonProperty("@id")
    public String id;

    @JsonProperty("@type")
    public String type;

    @JsonProperty("hydra:member")
    public List<HydraMemberMessage> hydraMember;

    @JsonProperty("hydra:totalItems")
    public int hydraTotalItems;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<HydraMemberMessage> getHydraMember() {
        return hydraMember;
    }

    public void setHydraMember(List<HydraMemberMessage> hydraMember) {
        this.hydraMember = hydraMember;
    }

    public int getHydraTotalItems() {
        return hydraTotalItems;
    }

    public void setHydraTotalItems(int hydraTotalItems) {
        this.hydraTotalItems = hydraTotalItems;
    }
}
