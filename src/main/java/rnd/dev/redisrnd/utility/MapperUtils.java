package rnd.dev.redisrnd.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUtils {
    private final ObjectMapper objectMapper;

    public String serialize(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T deSerialize(Object data, Class<T> tClass) {
        try {
            return objectMapper.readValue(String.valueOf(data), tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
