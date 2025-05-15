package rnd.dev.redisrnd.record.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequestForDeleteOperation {
    private String hashKey;
    private String dataKey;
}
