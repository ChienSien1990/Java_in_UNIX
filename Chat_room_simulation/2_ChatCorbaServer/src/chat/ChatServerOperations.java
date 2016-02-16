package chat;


public interface ChatServerOperations 
{
  String subscribe (String nick, chat.ChatClient c) throws chat.NameAlreadyUsed;
  void unsubscribe (String id) throws chat.UnknownID;
  void comment (String id, String text) throws chat.UnknownID;
} // interface ChatServerOperations
