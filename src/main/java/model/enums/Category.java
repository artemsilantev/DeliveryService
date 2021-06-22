package model.enums;

import lombok.Getter;

public enum Category {
    ELECTRONICS("electronic devices"),
    COMPUTERS_AND_NETWORKS("computer and network devices"),
    APPLIANCES("household appliances"),
    CONSTRUCTION_AND_REPAIR("construction and repair"),
    HOUSE_AND_GARDEN("House and garden"),
    AUTO_AND_MOTO("auto and moto"),
    BEAUTY_AND_SPORTS("beauty and sports"),
    CHILDREN_AND_MOTHERS("for children and mothers"),
    WORK_AND_OFFICE("work and office"),
    MEAL("meal");

    @Getter
    private final String info;

    Category(String info){
        this.info = info;
    }
}
