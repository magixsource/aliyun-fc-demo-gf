package gl.linpeng.gf;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import gl.linpeng.gf.annotation.PlainTextRequest;
import gl.linpeng.gf.base.PlainTextDTO;
import gl.linpeng.gf.base.ServerlessRequest;
import gl.linpeng.gf.base.ServerlessResponse;
import gl.linpeng.gf.controller.FunctionController;

/**
 * Hello world! example
 *
 * @author lin.peng
 */
@PlainTextRequest
public class App extends FunctionController<PlainTextDTO> implements PojoRequestHandler<PlainTextDTO, ServerlessResponse> {

    @Override
    public ServerlessResponse internalHandle(PlainTextDTO myPlainDto) {
        String greeting = "Welcome to Serverless world ! " + myPlainDto.getContent();
        return ServerlessResponse.builder().setObjectBody(greeting).build();
    }

    @Override
    public ServerlessResponse handleRequest(PlainTextDTO s, Context context) {
        // getFunction().getFunctionContext().put("ctx", context);
        ServerlessRequest request = ServerlessRequest.builder().setObjectBody(s).build();
        return handler(request);
    }
}
