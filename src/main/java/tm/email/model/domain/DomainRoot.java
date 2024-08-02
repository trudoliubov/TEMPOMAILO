package tm.email.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainRoot {
    @JsonProperty("@context")
    public String context;

    @JsonProperty("@id")
    public String idDomain;

    @JsonProperty("@type")
    public String type;

    @JsonProperty("hydra:member")
    public List<HydraMemberDomain> hydraMember;

    @JsonProperty("hydra:totalItems")
    public int hydraTotalItems;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIdDomain() {
        return idDomain;
    }

    public void setIdDomain(String idDomain) {
        this.idDomain = idDomain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<HydraMemberDomain> getHydraMember() {
        return hydraMember;
    }

    public void setHydraMember(List<HydraMemberDomain> hydraMember) {
        this.hydraMember = hydraMember;
    }

    public int getHydraTotalItems() {
        return hydraTotalItems;
    }

    public void setHydraTotalItems(int hydraTotalItems) {
        this.hydraTotalItems = hydraTotalItems;
    }
}
