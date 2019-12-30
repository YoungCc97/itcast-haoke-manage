package cn.itcast.haoke.dubbo.api.vo.ad.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Young
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexAdResult {
    private List<IndexAdResultData> list;
}