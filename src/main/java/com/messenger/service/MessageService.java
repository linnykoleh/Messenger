package com.messenger.service;


import com.messenger.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages(){
        final Message message = new Message(1L, "Hello World!", "Message 1");
        final Message jersey = new Message(2L, "Jersey", "Message 2");

        final ArrayList<Message> list = new ArrayList<>();
        list.add(message);
        list.add(jersey);
        return list;
    }
}
