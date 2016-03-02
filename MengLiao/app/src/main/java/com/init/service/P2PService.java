package com.init.service;

import com.init.listener.P2PListener;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Registration;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.ReportedData;
import org.jivesoftware.smackx.search.UserSearchManager;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by int on 4/19/15.
 */
public class P2PService  implements ChatManagerListener,MessageListener{
    private String account;
    private String password;
    private P2PListener listener;
    private ConnectionConfiguration connectionConfiguration;
    private XMPPConnection connection;
    public static String xmpp_host = "192.168.1.112";
    private static int xmpp_port = 5222;
    public static String xmpp_service_name = "192.168.1.112";
    private Chat newChat;
    public P2PService(String account, String password, P2PListener listener) {
        this.account = account;
        this.password = password;
        connectionConfiguration = new ConnectionConfiguration(xmpp_host,xmpp_port,xmpp_service_name);
        connectionConfiguration.setReconnectionAllowed(true);
        connectionConfiguration.setSendPresence(true);
        this.listener = listener;
    }
    public boolean connect()throws Exception{
        connection = new XMPPConnection(connectionConfiguration);
        try{
            connection.connect();
        }catch (XMPPException e){
            throw new IllegalStateException(e);
        }
        connection.login(account,password,"Spark 2.6.4");
        return connection.isConnected();
    }
    public void sendMessage(String content){
        if (newChat!=null){
            try {
                newChat.sendMessage(content);
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    }
    public void disConnect(){
        connection.disconnect();
    }

    public void createChat(String user){
        ChatManager chatManager = connection.getChatManager();
        newChat = chatManager.createChat(addXmppHost(user),null);
        chatManager.addChatListener(this);
    }
    @Override
    public void chatCreated(Chat chat, boolean b) {
        chat.addMessageListener(this);
    }

    @Override
    public void processMessage(Chat chat, Message message) {
        if (message.getBody()==null){
            return;
        }
        String msg = message.getBody();
        listener.getMessage(msg);
    }
    public String addXmppHost(String user){
        return user+"@"+xmpp_host;
    }

    public static boolean regXmpp(String account,String password){
        ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration(xmpp_host,xmpp_port,xmpp_service_name);
        connectionConfiguration.setReconnectionAllowed(true);
        connectionConfiguration.setSendPresence(true);
        connectionConfiguration.setSASLAuthenticationEnabled(false);
        connectionConfiguration.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        XMPPConnection connection = new XMPPConnection(connectionConfiguration);
        try {
            connection.connect();
        } catch (XMPPException e) {
            e.printStackTrace();
        }
        Registration reg = new Registration();
        reg.setType(IQ.Type.SET);
        reg.setTo(connection.getServiceName());
        reg.setUsername(account);
        reg.setPassword(password);
        reg.addAttribute("android","geolo_createUser_android");
        System.out.println("reg:" + reg);
        PacketFilter filter = new AndFilter(new PacketIDFilter(reg.getPacketID()),new PacketTypeFilter(IQ.class));
        PacketCollector collector = connection.createPacketCollector(filter);
        connection.sendPacket(reg);
        IQ result = (IQ)collector.nextResult(SmackConfiguration.getPacketReplyTimeout());
        System.out.println(result.toString());
        if (result.getType() == IQ.Type.RESULT){
            return true;
        }
        return false;

    }
    public ArrayList<String> searchUsers(String tag) {
        ArrayList<String> users = new ArrayList<String>();
        UserSearchManager userSearchManager = new UserSearchManager(connection);
        Form searchForm = null;
        try {
            searchForm = userSearchManager.getSearchForm("search." + connection.getServiceName());
            Form answerForm = searchForm.createAnswerForm();  // 根据原始表单创建一个要提交的新表单。

//            Iterator<FormField> filed = answerForm.getFields();
//            while(filed.hasNext()){
//            	FormField ff = filed.next();
//            	System.out.print("FormField.getType(): " + ff.getType() + " ");
//            	System.out.println();
//            	System.out.print("FormField.getLabel(): " + ff.getLabel() + " ");
//            	System.out.println();
//            	System.out.print("FormField.getVariable(): " + ff.getVariable() + " ");
//            	System.out.println();
//            }

//            answerForm.setAnswer("Username", true);
            answerForm.setAnswer("Name", true);
            answerForm.setAnswer("search", tag);
            ReportedData data = userSearchManager.getSearchResults(answerForm,
                    "search." + connection.getServiceName());
            // 每一列的值column:  jid,  Username ,Name,  Email
            Iterator<ReportedData.Row> it = data.getRows();
            ReportedData.Row row = null;
            System.out.println("data.getRows()返回是否为true？ ：  " + it.hasNext());
            while (it.hasNext()) {
                row = it.next();
                System.out.println(row.getValues("jid").next().toString());
                System.out.println(row.getValues("Username").next().toString());
                System.out.println(row.getValues("Name").next().toString());
                System.out.println(row.getValues("Email").next().toString());

                System.out.println("执行一次it.next()后还有吗？ ：  " + it.hasNext());
                // Log.d("UserName",
                // row.getValues("Username").next().toString());
                // Log.d("Name", row.getValues("Name").next().toString());
                // Log.d("Email", row.getValues("Email").next().toString());
                // 若存在，则有返回,UserName一定非空，其他两个若是有设，一定非空
                users.add(row.getValues("Username").next().toString());
            }
        } catch (XMPPException e) {
            e.printStackTrace();
        }
        return users;
    }

}
