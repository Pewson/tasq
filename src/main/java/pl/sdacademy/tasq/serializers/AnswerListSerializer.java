package pl.sdacademy.tasq.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.sdacademy.tasq.answer.Answer;

import java.io.IOException;
import java.util.List;

public class AnswerListSerializer extends StdSerializer<List<Answer>> {
    public AnswerListSerializer(){
        this(null);
    }
    private AnswerListSerializer(Class<List<Answer>> t) {
        super(t);
    }
    @Override
    public void serialize(List<Answer> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
/*        List<String> ids = new ArrayList<>();
        for (Question item : value) {
            ids.add(item.getId());
        }*/
        for (Answer item : value) {
            item.setQuestion(null);
        }
        gen.writeObject(value);
    }
}