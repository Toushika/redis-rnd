package rnd.dev.redisrnd.record.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {
    private String type;
    private String level;
    private int rating;
}
