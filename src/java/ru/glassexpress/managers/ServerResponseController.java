package ru.glassexpress.managers;

import ru.glassexpress.modules.db_command.DBCommand;
import ru.glassexpress.modules.select_command_factory.DBCommandFactory;
import ru.glassexpress.objects_DB.Composite;
import ru.glassexpress.objects_DB.ErrorObject;
import ru.glassexpress.objects_DB.UserObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ServerResponseController {

    String req;

    public synchronized String createResponse(HttpServletRequest request, UserObject user) {
        Composite compositeFromCommand;
        req = request.getQueryString();
        System.out.println("Incoming request: '"+req+"'");
        try {
            req = URLDecoder.decode(req, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Decoded request: '"+req+"'");
        if (req!=null) {
            DBCommandFactory factory = new DBCommandFactory();

            DBCommand command = factory.createCommand(req, user);
            compositeFromCommand = command.execute();

            if (compositeFromCommand != null) {
                return compositeFromCommand.toJSONObject().toString();

            } else {
                return createErrorResponse();
            }
        } else{
          return createErrorResponse();
        }

    }

    public synchronized String createErrorResponse(){
        Composite compositeFromCommand = new Composite();
        compositeFromCommand.addComponent(new ErrorObject());
        return compositeFromCommand.toJSONObject().toString();
    }

}