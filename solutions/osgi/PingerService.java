package labs.solutions.osgi;

import java.net.MalformedURLException;
import java.util.List;

public interface PingerService {
  int createPinger(String url) throws MalformedURLException;
  boolean cancelPinger(int pId);
  boolean isActive(int pId);
  List<String> audit(int pId);
  List<String> listActivePingers();
}
