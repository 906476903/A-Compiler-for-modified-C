package Error_handle; /**
 * Created by xsc on 2016/3/30.
 */

import java.util.*;
import java.io.*;

public class Error_msg {
    public static boolean anyerrors;
    public void complain(String msg){
        anyerrors = true;
        System.out.println("Error! "+msg);
    }
}
