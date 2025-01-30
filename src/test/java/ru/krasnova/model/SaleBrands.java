package ru.krasnova.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SaleBrands {

    @JsonProperty("conditions")
    private String conditions;

    @JsonProperty("date_start")
    private String dateStart;

    @JsonProperty("date_end")
    private String dateEnd;

    @JsonProperty("id")
    private int id;

    @JsonProperty("is_main")
    private boolean isMain;

    @JsonProperty("brands")
    private List<String> brands;

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }
}