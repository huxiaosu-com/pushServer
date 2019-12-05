/**
 * Project Name pushServer
 * File Name ConnectionFilter.java
 * Package Name com.huxiaosu.tools.pushserver.filter
 * Create Time 2018年3月15日
 * Create by name：liujie -- email: liujie@huxiaosu.com
 *
 */
package com.huxiaosu.tools.pushserver.filter;

import java.net.InetSocketAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

/** 
 * ClassName: ConnectionFilter.java <br>
 * Description: <br>
 * @author name：liujie <br>email: liujie@huxiaosu.com <br>
 * @date: 2018年3月15日<br>
 */
public class ConnectionFilter extends IoFilterAdapter{
    
    private static Log log = LogFactory.getLog(ConnectionFilter.class);

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        InetSocketAddress socketAddress = (InetSocketAddress) session.getRemoteAddress();
        log.debug("远程服务器地址：" + socketAddress.getAddress().getHostAddress());
        nextFilter.messageReceived(session, message);
    }
}
