package pl.sdacademy.tasq.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.sdacademy.tasq.question.Question;

import java.io.IOException;
import java.util.List;

public class QuestionListSerializer extends StdSerializer<List<Question>> {
    public QuestionListSerializer(){
        this(null);
    }
    private QuestionListSerializer(Class<List<Question>> t) {
        super(t);
    }
    @Override
    public void serialize(List<Question> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
/*        List<String> ids = new ArrayList<>();
        for (Question item : value) {
            ids.add(item.getId());
        }*/
        for (Question item : value) {
            item.setTest(null);
        }
        gen.writeObject(value);
    }
}