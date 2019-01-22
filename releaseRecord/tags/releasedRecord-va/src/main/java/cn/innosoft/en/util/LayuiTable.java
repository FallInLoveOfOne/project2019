package cn.innosoft.en.util;


import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayuiTable  extends HashMap<String, Object> {

    public static LayuiTable data(PageResponse<Map<String, Object>> pageResponse) {
        LayuiTable tableData = new LayuiTable();
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageResponse.getTotal());
        tableData.put("data", pageResponse.getRows());
        return tableData;
    }


    /**
     * 客户端返回字符串
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }

    }
}


