package rnd.dev.redisrnd.record.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequestForGetOperation {
    private String hashKey;
    private String dataKey;
}
