package rnd.dev.redisrnd.record.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rnd.dev.redisrnd.record.entity.BookInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestForSaveOperation {
    private String hashKey;
    private String dataKey;
    private long ttlSeconds;
    private BookInfo bookInfo;
}
