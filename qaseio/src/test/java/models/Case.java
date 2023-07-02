package models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    private String title;
    private String code;
    private String description;
    private String preconditions;
    private String postconditions;
    private int severity;
    private int priority;

}
