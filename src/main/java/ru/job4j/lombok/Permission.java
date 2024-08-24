package ru.job4j.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Permission {
    private Integer id;
    private String name;
    @Singular("rules")
    private List<String> rules;
}
