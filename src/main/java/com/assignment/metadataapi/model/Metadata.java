package com.assignment.metadataapi.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class Metadata implements Serializable {
    @NotEmpty(message = "Title must not be empty")
    private String title;
    @NotEmpty(message = "version must not be empty")
    private String version;
    @NotEmpty
    private List<Maintainers> maintainers;
    @NotEmpty(message = "company must not be empty")
    private String company;
    @NotEmpty(message = "website must not be empty")
    private String website;
    @NotEmpty(message = "source must not be empty")
    private String source;
    @NotEmpty(message = "license must not be empty")
    private String license;
    @NotEmpty(message = "description must not be empty")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Maintainers> getMaintainers() {
        return maintainers;
    }

    public void setMaintainers(List<Maintainers> maintainers) {
        this.maintainers = maintainers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
