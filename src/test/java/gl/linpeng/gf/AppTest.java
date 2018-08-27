package gl.linpeng.gf;

import com.alibaba.fastjson.JSON;
import gl.linpeng.gf.base.JsonDTO;
import gl.linpeng.gf.base.ServerlessRequest;
import gl.linpeng.gf.base.ServerlessResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    App app;
    ServerlessRequest request;
    JsonDTO dto;
    @Before
    public void setUp() {
        app = new App();
        String content = "Green Tim";
        dto = new JsonDTO();
        dto.setContent(content);
        request = ServerlessRequest.builder().setObjectBody(dto).build();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ServerlessResponse response = app.handler(request);
        System.out.println(JSON.toJSONString(response, true));
        Assert.assertNotNull(response);
    }
}
