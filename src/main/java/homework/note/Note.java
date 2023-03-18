package homework.note;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Note {
    private long id;
    private String title;
    private String content;
}
