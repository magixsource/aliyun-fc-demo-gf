package gl.linpeng.gf;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import gl.linpeng.gf.annotation.PlainTextRequest;
import gl.linpeng.gf.annotation.Translate;
import gl.linpeng.gf.base.JsonDTO;
import gl.linpeng.gf.base.PlainTextDTO;
import gl.linpeng.gf.base.ServerlessRequest;
import gl.linpeng.gf.base.ServerlessResponse;
import gl.linpeng.gf.controller.FunctionController;

/**
 * Hello world! example
 *
 * @author lin.peng
 */
@Translate(enabled = false)
public class App extends FunctionController<JsonDTO> implements PojoRequestHandler<JsonDTO, ServerlessResponse> {

    @Override
    public ServerlessResponse internalHandle(JsonDTO jsonDTO) {
        // String greeting = "Welcome to Serverless world ! " + jsonDTO.getContent();
        return ServerlessResponse.builder().setObjectBody(jsonDTO).build();
    }

    @Override
    public ServerlessResponse handleRequest(JsonDTO s, Context context) {
        // getFunction().getFunctionContext().put("ctx", context);
        ServerlessRequest request = ServerlessRequest.builder().setObjectBody(s).build();
        return handler(request);
    }
}
