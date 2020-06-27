package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Feedback;

import java.sql.Timestamp;


@Data
@ToString(exclude = "content")
@NoArgsConstructor
public class FeedbackModel {

    private int id;

    private String name;

    private String email;

    private String subject;

    private String content;

    private Timestamp dateSend;

    private Boolean isRead;

    public FeedbackModel(Feedback feedback) {
        this.id = feedback.getId();
        this.name = feedback.getName();
        this.email = feedback.getEmail();
        this.subject = feedback.getSubject();
        this.content = feedback.getContent();
        this.dateSend = feedback.getDateSend();
        this.isRead = feedback.getIsRead();
    }
}
