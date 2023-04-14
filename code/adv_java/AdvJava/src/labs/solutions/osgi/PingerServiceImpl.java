package labs.solutions.osgi;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PingerServiceImpl implements PingerService {

  Map<Integer, PingerEntry> activePingers;
  Map<Integer, HttpPinger> inactivePingers;

  private static int counter;
  private final ScheduledExecutorService pingService;

  public PingerServiceImpl() {
    activePingers = new HashMap<Integer, PingerEntry>();
    inactivePingers = new HashMap<Integer, HttpPinger>();
    pingService = Executors.newSingleThreadScheduledExecutor();
  }

  @Override
  public int createPinger(String url) throws MalformedURLException {
    int id = 0;

    if(url!= null && url.startsWith("http://")) {
      HttpPinger pinger = new HttpPinger(url);
      id = ++counter;
      ScheduledFuture future = pingService.scheduleAtFixedRate(pinger, 5L, 60L, TimeUnit.SECONDS);
      activePingers.put(id, new PingerEntry(pinger, id, future));
    }

    return id;
  }

  @Override
  public boolean cancelPinger(int pId) {
    boolean returnValue = false;

    if(activePingers.containsKey(pId)) {
      PingerEntry tmpP = activePingers.get(pId);

      if(tmpP.future.cancel(false)) {
        activePingers.remove(pId);
        inactivePingers.put(pId,tmpP.pinger);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isActive(int pId) {
    return activePingers.containsKey(pId);
  }

  @Override
  public List<String> audit(int pId) {
    if(activePingers.containsKey(pId)) {
      HttpPinger tmpP = activePingers.get(pId).pinger;
      return tmpP.getAuditLog();

    } else if(inactivePingers.containsKey(pId)) {
          HttpPinger tmpP = inactivePingers.get(pId);
          return tmpP.getAuditLog();
    }
    return null;

  }

  @Override
  public List<String> listActivePingers() {
    List<String> urls = new ArrayList<String>();

      for(PingerEntry tmpP : activePingers.values()) {
        urls.add(tmpP.pinger.getUrl());
      }

      return urls;
  }
}
