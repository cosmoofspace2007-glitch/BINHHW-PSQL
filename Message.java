package Baiseasion16;

import java.time.LocalDateTime;

public class Message
{
    private String sender;
    private String content;
    private LocalDateTime date;

    public Message(String sender, String content, LocalDateTime date)
    {
        this.sender = sender;
        this.content = content;
        this.date = date;
    }

    public  String getSender()
    {
        return sender;
    }
    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public LocalDateTime getDate()
    {
        return date;
    }
    public void setDate(LocalDateTime date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Message{" + "sender=" + sender + ", content=" + content + ", date=" + date + '}';
    }
}

