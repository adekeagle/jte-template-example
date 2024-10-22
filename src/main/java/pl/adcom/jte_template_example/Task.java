package pl.adcom.jte_template_example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Task {

    private Long id;
    private String name;
    private Boolean isDone;

}
